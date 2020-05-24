package com.example.demo.controller;

import com.example.demo.groovy.GroovyCommonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/test/groovy/script")
    public String testGroovyScript() throws Exception {
        String result3 = (String) GroovyCommonUtil.invokeMethod("ProcessControl.groovy", "test");
        return result3;
    }
}
