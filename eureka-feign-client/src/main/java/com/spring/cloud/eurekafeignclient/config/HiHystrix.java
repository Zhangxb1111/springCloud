package com.spring.cloud.eurekafeignclient.config;

import com.spring.cloud.eurekafeignclient.serviceI.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi "+name+",sorry,error!";
    }
}
