package com.glanz.serializer.controller;

import com.glanz.serializer.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public User getUser() {
        User u = new User();
        u.setUsername("glanz");
        u.setPassword("123456");
        u.setEmail("glanz@aaa.com");
        return u;
    }
}
