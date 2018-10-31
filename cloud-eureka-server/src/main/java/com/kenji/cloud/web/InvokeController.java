package com.kenji.cloud.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InvokeController {


    @Autowired
    RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "invokeError")
    @RequestMapping(value = "/invoke")
    public String invoke(@RequestParam String serviceName, @RequestParam String param) {
        System.out.println("http://" + serviceName + "/" + param);
        return restTemplate.getForObject("http://" + serviceName + "/" + param, String.class);
    }


    public String invokeError(String serviceName, String param) {
        return "error";
    }
}
