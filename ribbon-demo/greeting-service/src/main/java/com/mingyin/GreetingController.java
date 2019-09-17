package com.mingyin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        System.out.println("接收到了一次请求调用");
        return "hello, " + name;
    }

}
