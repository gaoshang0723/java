package com.msop.merber2.merber2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerberController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/index")
    public String index(){
        return " This is Merber,port is "+port;
    }
}
