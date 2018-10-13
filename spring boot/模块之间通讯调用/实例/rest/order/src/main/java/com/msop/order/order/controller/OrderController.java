package com.msop.order.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getmerber")
    public String getmerber(){
        String url="http://Merber/index";
        return restTemplate.getForObject(url,String.class);
    }

}
