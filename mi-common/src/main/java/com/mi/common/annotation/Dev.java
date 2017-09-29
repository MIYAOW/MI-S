package com.mi.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 区分产品
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/8.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Dev {

}
