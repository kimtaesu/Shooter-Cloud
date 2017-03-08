package com.hucet.metrics.schedule;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hucet.metrics.dto.SystemPublicMetricsDto;
import com.hucet.metrics.service.NodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@EnableScheduling
@Slf4j
public class AggregateScheduler {

    @Autowired
    NodeService nodeService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    void metricsAggregate() {
        nodeService.getAllNode().stream()
                .forEach(instance -> {
                    log.info("asdads");
                    aaa(instance);
                });
    }

    @Async(value = "aggregateExecutor")
    void aaa(ServiceInstance instance) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(instance.getUri() + "/metrics", HttpMethod.GET, null, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            try {
                SystemPublicMetricsDto systemPublicMetricsDto = objectMapper.readValue(responseEntity.getBody(), SystemPublicMetricsDto.class);
                log.info(systemPublicMetricsDto.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Bean
    public AsyncTaskExecutor aggregateExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(15);
        executor.setRejectedExecutionHandler(abortPolicy());
        return executor;
    }

    @Bean
    public RejectedExecutionHandler abortPolicy() {
        return new ThreadPoolExecutor.AbortPolicy();
    }
}
