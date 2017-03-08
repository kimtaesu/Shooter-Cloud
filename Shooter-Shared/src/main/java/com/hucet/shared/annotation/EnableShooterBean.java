package com.hucet.shared.annotation;

import com.hucet.shared.config.CorsFilter;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Import(CorsFilter.class)
public @interface EnableShooterBean {
}