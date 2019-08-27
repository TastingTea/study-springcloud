package com.mingyin.ssm.dao.impl;

import com.mingyin.ssm.dao.UserDAO;
import com.mingyin.ssm.domain.User;
import com.mingyin.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理模块的DAO组件实现类
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	/**
	 * 用户管理模块的mapper组件
	 */
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	public List<User> listUsers() {
		return userMapper.listUsers();
	}
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	public User getUserById(Long id) {
		return userMapper.getUserById(id);
	}
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	public void saveUser(User user) {
		userMapper.saveUser(user); 
	}
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	public void updateUser(User user) {
		userMapper.updateUser(user); 
	}
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	public void removeUser(Long id) {
		userMapper.removeUser(id); 
	}
	
}
