package com.mi.feign;

import com.mi.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign消费模式
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/2.
 */
@RestController
public class FeignController {


    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return feignService.Hello(name);
    }

}
