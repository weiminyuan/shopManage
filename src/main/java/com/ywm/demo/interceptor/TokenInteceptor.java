package com.ywm.demo.interceptor;

import com.ywm.demo.annotation.MemberAnnotation;
import com.ywm.demo.annotation.TokenAnnotation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 查询登录接口验证
 */
@Component
public class TokenInteceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //redis获取token值 比较session，判断是否已经登录\
        String token = request.getParameter("token");
        String redisToken = "123456789";
        if (!StringUtils.isEmpty(redisToken) && !redisToken.equals(token)) {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("{code:0,message:\"not login!\"}");
            return false;
        }
        if (token != null) {
            System.out.println("AuthCheckInteceptor--接口访问权限：级别类" + handlerMethod.getBean().getClass().getName());
        }
        return true;
    }

}
