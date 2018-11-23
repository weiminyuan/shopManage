package com.ywm.demo.controller.user;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/findOneUser")
    @ResponseBody
    public String findOneUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "张三");
        map.put("userName", "zhangsan");
        map.put("password", "123456");
        map.put("desc", "三好青年");
        return JSON.toJSONString(map);
    }
}
