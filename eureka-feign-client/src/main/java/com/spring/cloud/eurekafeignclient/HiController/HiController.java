package com.spring.cloud.eurekafeignclient.HiController;

import com.spring.cloud.eurekafeignclient.serviceI.impl.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    /**
     * test feign
     * @param name
     * @return
     */
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam(value = "name",defaultValue = "default") String name){
        return hiService.sayHi(name);
    }
}
