package com.ishops.merber.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MerberController {

    @GetMapping("/merber")
    public Integer merber(@RequestParam Integer age){
        return age;
    }
}
