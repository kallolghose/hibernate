package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String demo(){
        return "{\"key\":\"value\"}";
    }
}
