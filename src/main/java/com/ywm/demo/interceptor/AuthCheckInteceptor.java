package com.ywm.demo.interceptor;

import com.ywm.demo.annotation.MemberAnnotation;
import com.ywm.demo.annotation.TokenAnnotation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
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
public class AuthCheckInteceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        //获取类上注解
        TokenAnnotation token = handlerMethod.getBeanType().getAnnotation(TokenAnnotation.class);
        // 获取出方法上的Access注解
        MemberAnnotation member = method.getAnnotation(MemberAnnotation.class);
//        MemberAnnotation auth = methodHandler.getMethodAnnotation(MemberAnnotation.class);
        if (token != null || member != null) {
            HttpSession session = request.getSession();
            //redis获取token值 比较session，判断是否已经登录\
            String redisToken = "123456789";
            if (!StringUtils.isEmpty(redisToken) && ! redisToken.equals(session.getAttribute("token"))){
                PrintWriter printWriter = response.getWriter();
                printWriter.write("{code:0,message:\"not login!\"}");
                return false;
            }
            if(token!=null){
                System.out.println("AuthCheckInteceptor--接口访问权限：级别类"+handlerMethod.getBean().getClass().getName());
            }
            if(member!=null){
                System.out.println("AuthCheckInteceptor--接口访问权限：级别方法"+method.getName());
            }
            return true;
        }
        // 如果注解为null, 说明不需要拦截, 直接放过
        return true;
    }

}
