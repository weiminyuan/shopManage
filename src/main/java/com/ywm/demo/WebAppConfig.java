package com.ywm.demo;

import com.ywm.demo.annotation.MemberAnnotation;
import com.ywm.demo.annotation.TokenAnnotation;
import com.ywm.demo.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{"/static/**","index/jsp"};
        //基于类的注解，所有方法必须签名、登录才可访问
        ResourceAuthHandleInterceptor rah = new ResourceAuthHandleInterceptor();
        rah.setAnnotationClass(TokenAnnotation.class);
        rah.setHandlerInterceptor(new HandlerInterceptor[]{new TokenInteceptor(), new SignInteceptor()});
        registry.addInterceptor(rah).addPathPatterns("/**").excludePathPatterns(excludes);

        ResourceAuthHandleInterceptor rah1 = new ResourceAuthHandleInterceptor();
        rah1.setAnnotationClass(MemberAnnotation.class);
        rah1.setHandlerInterceptor(new HandlerInterceptor[]{new MemberInteceptor()});
        registry.addInterceptor(rah1).addPathPatterns("/**").excludePathPatterns(excludes);;
        super.addInterceptors(registry);
    }

    /**
     * 配置jsp视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
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
