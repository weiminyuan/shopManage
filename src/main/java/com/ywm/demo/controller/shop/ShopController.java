package com.ywm.demo.controller.shop;

import com.alibaba.fastjson.JSON;
import com.ywm.demo.annotation.MemberAnnotation;
import com.ywm.demo.annotation.TokenAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @RequestMapping("/findOneShop")
    @ResponseBody
    @MemberAnnotation
    public String findOneUser(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "杭州第一佳火锅店");
        map.put("address", "浙江省杭州市西湖区108号");
        map.put("pay", "100");
        map.put("desc", "好吃火锅");
        return JSON.toJSONString(map);
    }
}
