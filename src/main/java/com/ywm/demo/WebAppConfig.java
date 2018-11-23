package com.ywm.demo;

import com.ywm.demo.annotation.MemberAnnotation;
import com.ywm.demo.annotation.TokenAnnotation;
import com.ywm.demo.interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {
    @Autowired
    private MyInterceptor myInterceptor;
    @Autowired
    private AuthCheckInteceptor authCheckInteceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //基于类的注解，所有方法必须签名、登录才可访问
        ResourceAuthHandleInterceptor rah = new ResourceAuthHandleInterceptor();
        rah.setAnnotationClass(TokenAnnotation.class);
        rah.setHandlerInterceptor(new HandlerInterceptor[]{new TokenInteceptor(), new SignInteceptor()});
        registry.addInterceptor(rah).addPathPatterns("/**");

        ResourceAuthHandleInterceptor rah1 = new ResourceAuthHandleInterceptor();
        rah1.setAnnotationClass(MemberAnnotation.class);
        rah1.setHandlerInterceptor(new HandlerInterceptor[]{new MemberInteceptor()});
        registry.addInterceptor(rah1).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态资源处理
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
