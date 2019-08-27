package com.mingyin.ssm.service;

import com.mingyin.ssm.domain.User;

import java.util.List;

/**
 * 用户管理模块的service组件接口
 *
 */
public interface UserService {

	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	List<User> listUsers();
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	User getUserById(Long id);
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	void removeUser(Long id);
	
}
