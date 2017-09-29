package com.mi;

import com.mi.common.swagger.BaseSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 需配置Swagger API Doc 继承既可
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/29.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

}
