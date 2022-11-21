package com.example.cloud_eureka_rest;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class CloudEurekaRestApplication {
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private GreetingClient greetingClient;

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaRestApplication.class, args);
    }

    @RequestMapping("get-greeting-no-feign")
    public String getHello(){
        InstanceInfo info = eurekaClient
                .getApplication("spring-cloud-eureka-client")
                .getInstances()
                .get(0);
        System.out.println("hostname:"+info.getHostName());
        System.out.println("port:"+info.getPort());
        System.out.println("ip:"+info.getIPAddr());
        return greetingClient.greeting();
    }

}
