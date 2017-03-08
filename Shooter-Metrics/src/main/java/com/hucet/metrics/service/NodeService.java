package com.hucet.metrics.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by taesu on 2017-03-09.
 */
@Service
@Slf4j
public class NodeService {
    @Autowired
    DiscoveryClient discoveryClient;

    public List<? extends ServiceInstance> getAllNode() {
        return discoveryClient.getServices().stream()
                .flatMap(s -> {
                    return discoveryClient.getInstances(s).stream();
                })
                .collect(Collectors.toList());
    }
}
