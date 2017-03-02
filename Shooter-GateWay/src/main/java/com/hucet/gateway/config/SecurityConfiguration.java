package com.hucet.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity

@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Bean
//    @Primary
//    public OAuth2ClientContextFilter dynamicOauth2ClientContextFilter() {
//        return new DynamicOauth2ClientContextFilter();
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // TODO CSRF
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/api/v1/user/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
