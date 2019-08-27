package com.mingyin.ssm;

import com.mingyin.ssm.config.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
/*
 * 将数据源bean的配置类，导入进来，就相当于你以前搞多个xml的时候，将多个xml导入一个总的xml中
 */
@Import(DruidDataSourceConfig.class)
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
