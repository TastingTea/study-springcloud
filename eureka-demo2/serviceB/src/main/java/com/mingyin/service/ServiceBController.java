package com.mingyin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class ServiceBController {

	/**
	 *
	 * 这个东西，直接就是人家jar包里提供的接口和实现类都有了，不需要我们去关注他
	 * 我们就直接使用即可，直接引用一个IService，加上一个@autowired，就可以使用人家的服务了
	 *
	 * 或者说，我们就在本地定义一个很薄很薄的接口，IServiceA -> 直接基于jar包里提供的一些东西简单配置一些注解就可以
	 *
	 */
	@Autowired
	private IServiceA serviceA;

	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
	public String greeting(@PathVariable("name") String name) {
		return serviceA.sayHello(name);
	}
}
