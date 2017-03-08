package com.hucet.shared;


import com.hucet.shared.config.CorsFilter;
import com.hucet.shared.properties.ShooterProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import({CorsFilter.class})
@EnableConfigurationProperties(ShooterProperties.class)
public class ShooterBeanContext {
}
