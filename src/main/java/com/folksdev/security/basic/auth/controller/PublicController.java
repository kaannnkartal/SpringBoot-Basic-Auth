package com.folksdev.security.basic.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String helloWorld(){
        return "Hello world from public endpoint!";
    }

    @GetMapping("/user")
    public String helloWorldUserPrivate(){
        return "Hello World! from user public endpoint";
    }

    @GetMapping("/admin")
    public String helloWorldAdminPrivate(){
        return "Hello world! from user public admin!";
    }


}
