package com.ywm.demo.annotation;

import java.lang.annotation.*;

/**
 * 登录查询
 * 方法级
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MemberAnnotation {

}
