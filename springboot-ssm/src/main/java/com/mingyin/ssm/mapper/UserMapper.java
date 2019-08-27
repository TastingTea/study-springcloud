package com.mingyin.ssm.mapper;


import com.mingyin.ssm.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户管理模块的Mapper组件
 */
@Mapper
public interface UserMapper {

	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	@Select("SELECT * FROM user")  
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")  
	})
	List<User> listUsers();
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")  
	})
	User getUserById(@Param("id") Long id);
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")  
	void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	@Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")  
	void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	@Delete("DELETE FROM user WHERE id=#{id}")
	void removeUser(@Param("id") Long id);
	
}
