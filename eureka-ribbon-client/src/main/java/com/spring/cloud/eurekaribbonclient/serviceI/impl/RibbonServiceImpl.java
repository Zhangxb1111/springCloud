package com.spring.cloud.eurekaribbonclient.serviceI.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.spring.cloud.eurekaribbonclient.serviceI.RibbonServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl implements RibbonServiceI {

    private static final Logger log = LoggerFactory.getLogger(RibbonServiceImpl.class);
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    @Override
    public String hi(String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        log.info("ip:"+serviceInstance.getHost()+" port:"+serviceInstance.getPort()+" uri:"+serviceInstance.getUri()
        +" serviceId:"+serviceInstance.getServiceId());
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }

    /**
     * 此方法参数必须和正常方法相同
     * @param name
     * @return
     */
    public String hiError(String name){
        return "hi"+name+",sorry,error!";
    }
}
