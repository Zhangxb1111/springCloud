package com.spring.cloud.eurekamonitorclient.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.turbine.streaming.servlet.TurbineStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ServletRegistrationBean getServlet() {
        TurbineStreamServlet turbineStreamServlet = new TurbineStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(turbineStreamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/turbine.stream");
        registrationBean.setName("TurbineStreamServlet");
        return registrationBean;
    }
}
