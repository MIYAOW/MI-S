package com.mi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign调用接口
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/2.
 */
@FeignClient(name = "mi-eureka-client" , fallback = HystrixClientFallback.class)
public interface FeignService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String Hello(@RequestParam(value = "name") String name);

}

class HystrixClientFallback implements FeignService {
    @Override
    public String Hello(String name) {
        return "error";
    }
}


