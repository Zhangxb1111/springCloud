package com.spring.cloud.eurekafeignclient.serviceI.impl;

import com.spring.cloud.eurekafeignclient.serviceI.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
