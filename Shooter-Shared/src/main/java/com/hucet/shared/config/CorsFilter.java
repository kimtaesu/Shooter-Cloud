package com.hucet.shared.config;

import com.hucet.shared.properties.ShooterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@ConditionalOnProperty(value = "shooter.origin.enable", matchIfMissing = true)
public class CorsFilter implements Filter {
    @Autowired
    ShooterProperties shooterProperties;

    @PostConstruct
    void init() {
        log.info("CorsFilter Bean Create");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        String originUrl = "http://" + shooterProperties.getOrigin().getHost() + ":" +
                shooterProperties.getOrigin().getPort();
        response.setHeader("Access-Control-Allow-Origin", originUrl);
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setHeader("Access-Control-Allow-Methods",
                    "POST,GET, PUT,DELETE");
            response.setHeader("Access-Control-Allow-Headers", "content-type,access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
