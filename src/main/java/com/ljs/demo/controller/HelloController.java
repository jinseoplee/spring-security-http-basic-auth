package com.ljs.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello admin";
    }

    @GetMapping("/manager")
    public String manager() {
        return "Hello manager";
    }
}
