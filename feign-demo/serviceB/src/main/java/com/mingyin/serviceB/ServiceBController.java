package com.mingyin.serviceB;

import com.mingyin.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ServiceB/user")
public class ServiceBController {

    @Autowired
    private ServiceAClient serviceA;

    @RequestMapping(value = "/sayHello/{id}", method = RequestMethod.GET)
    public String greeting(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age) {
        return serviceA.sayHello(id, name, age);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        return serviceA.createUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return serviceA.updateUser(id, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Long id) {
        return serviceA.deleteUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable("id") Long id) {
        return serviceA.getById(id);
    }

}
