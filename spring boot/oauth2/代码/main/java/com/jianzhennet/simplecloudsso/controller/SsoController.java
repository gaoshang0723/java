package com.jianzhennet.simplecloudsso.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SsoController {
    @GetMapping("/who")
    @ResponseBody
    public String who() {
        return "simplecloud-sso";
    }
    @GetMapping("/get")
    public String gettoken(){
        return null;
    }

    @RequestMapping("/encode/{password}")
    @ResponseBody
    public String passwordEncoder(@PathVariable("password") String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return  bCryptPasswordEncoder.encode(password);
    }



}
