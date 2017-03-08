package com.hucet.shared;


import com.hucet.shared.config.CorsFilter;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


@Component
@Import({CorsFilter.class})
public class ShooterBeanContext {
}
