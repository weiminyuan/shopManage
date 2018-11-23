package com.ywm.demo.annotation;

import java.lang.annotation.*;

/**
 * 登录查询
 * 类级
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TokenAnnotation {

}
