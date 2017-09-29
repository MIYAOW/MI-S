package com.mi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/7.
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${version}")
    private String from;
    @RequestMapping("/version")
    public String from() {
        return this.from;
    }
}
