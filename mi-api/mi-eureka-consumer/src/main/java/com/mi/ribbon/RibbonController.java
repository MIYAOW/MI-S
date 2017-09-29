package com.mi.ribbon;

import com.mi.service.impl.RibbonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon消费模式
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/2.
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RibbonServiceImpl ribbonServiceImpl;

    @RequestMapping(value = "/helloR",method = RequestMethod.GET)
    public String hello(){
        return restTemplate.getForEntity("http://MI-EUREKA-CLIENT/hi?name=Ribbon", String.class).getBody();
    }

    @RequestMapping(value = "/helloH",method = RequestMethod.GET)
    public String helloHi(){
        return  ribbonServiceImpl.helloToYou();
    }


}
