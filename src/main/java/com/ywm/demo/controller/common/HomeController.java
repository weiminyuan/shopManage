package com.ywm.demo.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yuanweimin
 * @Date: 2018/12/18 11:38
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/"})
    public String index(){
        return "index";
    }
    @RequestMapping(value = {"/first"})
    public String firstPdf(){
        return "firstPdf";
    }
}
