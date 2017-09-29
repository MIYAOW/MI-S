package com.mi.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon接口实现类
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/3.
 */
@Service
public class RibbonServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloToYou(){
        return  restTemplate.getForEntity("http://MI-EUREKA-CLIENT/hi?name=RibbonHystrix",String .class).getBody();
    }

    public String helloError(){
        return "I am not here Ribbon -->  Error";
    }


}
