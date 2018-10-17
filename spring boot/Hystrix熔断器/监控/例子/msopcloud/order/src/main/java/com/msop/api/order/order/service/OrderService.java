package com.msop.api.order.order.service;

import com.msop.api.order.order.api.impl.Merber;
import com.msop.api.order.order.api.untity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderService {

    @Autowired
    private Merber merber;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/ordertomerber")
    public String OrderToMerber(String name) {
        System.out.println(Thread.currentThread().getName());
        return merber.GetMerber(name).toString();
    }

    public String fallback(String name) {
        return "Error" + name;
    }
}
