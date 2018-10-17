package com.msop.api.order.order.api.impl;

import com.msop.api.order.order.api.untity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="merber")
public interface Merber {
    @RequestMapping("/getmerber")
    public User GetMerber(@RequestParam ("name") String name);
}