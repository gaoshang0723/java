package com.msop.api.merber.merber.api.service;

import com.msop.api.merber.merber.untity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerberService {
    @Autowired
    private Environment env;
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/MerberInfo")
    public String MerberInfo(){
        return  "name is "+env.getProperty("spring.application.name")+",port:"+env.getProperty("server.port");
    }
    public String fallback(){
        return "error";
    }
    @RequestMapping("/getmerber")
    public User GetMerber(String name){
       User user = new User();
       user.setName(name);
       user.setAge(Integer.parseInt(env.getProperty("server.port")));
       return user;
    }
}
