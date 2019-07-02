package com.spring.cloud.eurekaribbonclient.restController;

import com.spring.cloud.eurekaribbonclient.serviceI.RibbonServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    @Autowired
    private RibbonServiceI ribbonServiceI;

    @GetMapping("/testRest")
    public String testRest(@RequestParam(required = false,defaultValue = "default") String name){
        return ribbonServiceI.hi(name);
    }
}
