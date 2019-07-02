package com.spring.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Value(value = "${server.port}")
    private String port;

    @GetMapping(value = "/hi")
    public String home(@RequestParam(value = "name") String name){
        return "hi "+name+",I am from port "+port;
    }
}
