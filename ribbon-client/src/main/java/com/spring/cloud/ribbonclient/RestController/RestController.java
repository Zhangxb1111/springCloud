package com.spring.cloud.ribbonclient.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/testRibbon")
    public String testRest(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("stores");
        return serviceInstance.getServiceId()+" "+serviceInstance.getUri();
    }

}
