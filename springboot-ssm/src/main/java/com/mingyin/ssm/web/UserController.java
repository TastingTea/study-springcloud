package com.mingyin.ssm.web;

import com.mingyin.ssm.domain.User;
import com.mingyin.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户管理模块的控制器组件
 * 
 * 先初步介绍一下，什么是RESTful风格的接口，其实这个是一种风格和思想
 * 就是说他认为系统里的各种东西都是资源，暴露出去的接口，都是对资源的一种操作
 * 所以在请求URL里面，按照一种风格标志出来你要操作的是哪个资源
 * 然后通过HTTP method来定义你要对这个资源执行什么样的操作呢？
 *
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * 用户管理模块的service组件
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 查询所有用户
	 * @return 用户信息
	 * 
	 * 这个@GetMapping注解表示的就是，这个接口仅仅接收GET类型的http请求
	 * 
	 */
	@GetMapping("/")  
	public List<User> listUsers() {
		return userService.listUsers();
	}
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 * 
	 * {id}，就是通过占位符的方式，可以让我们提取请求URL中的参数
	 * 
	 */
	@GetMapping("/{id}")  
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	@PostMapping("/")  
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user); 
	}
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	@PutMapping("/{id}")
	public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		user.setId(id);
		userService.updateUser(user);
	}
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") Long id) {
		userService.removeUser(id); 
	}
	
}

