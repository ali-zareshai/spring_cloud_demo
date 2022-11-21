package com.example.cloud_eureka_client;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
    @RequestMapping("/hello")
    String getHello();
}
