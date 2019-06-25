package com.team142.tode.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticWebPageConfig {

    @RequestMapping(value = "/tw")
    public String index() {
        return "index";
    }
}
