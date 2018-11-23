package com.ywm.demo.annotation;

import java.lang.annotation.*;

/**
 * 查询验签
 * 方法
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SignAnnotation {

}
