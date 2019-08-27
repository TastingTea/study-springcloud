package com.mingyin.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 
 * 非常经典的@Configuration的用法
 * 我们现在要配置一个数据源，基于一个开源的数据库连接池的组件来配置即可，c3p0，dbcp，druid
 * 
 * 如果换成是我们以前还使用传统的跟spring整合的方式
 * 必然是在applicationContext.xml中，去配置一个bean，dataSource，所有的配置都是放在applicationContext.xml中的
 * 
 * 但是，现在spring boot的核心思想，就是配置全部放application.properties集中起来管理所有配置
 * 同时xml中配置bean的方式，全部改成在java代码中，采用注解的方式来配置bean
 * 其实@Configuration就代表了说，这个类是一个类似于以前的xml配置文件的一个配置类
 * 在这个类中可以将外部的application.properties中的需要的配置加载进来，使用@Value注解即可加载外部配置
 *
 *
 */
@Configuration  
public class DruidDataSourceConfig {  
   
	/*
	 * 看下面所有的配置，都是创建一个数据源需要的一些配置项
	 * 直接通过@Value的注解，将需要的配置项的值，从外部的application.properties文件中加载进来
	 */
    @Value("${spring.datasource.url}")  
    private String dbUrl;  
    @Value("${spring.datasource.username}")  
    private String username;  
    @Value("${spring.datasource.password}")  
    private String password;  
    @Value("${spring.datasource.driverClassName}")  
    private String driverClassName;  
    @Value("${spring.datasource.initialSize}")  
    private int initialSize;  
    @Value("${spring.datasource.minIdle}")  
    private int minIdle;  
    @Value("${spring.datasource.maxActive}")  
    private int maxActive;  
    @Value("${spring.datasource.maxWait}")  
    private int maxWait;  
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")  
    private int timeBetweenEvictionRunsMillis;  
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
    private int minEvictableIdleTimeMillis;  
    @Value("${spring.datasource.validationQuery}")  
    private String validationQuery;  
    @Value("${spring.datasource.testWhileIdle}")  
    private boolean testWhileIdle;  
    @Value("${spring.datasource.testOnBorrow}")  
    private boolean testOnBorrow;  
    @Value("${spring.datasource.testOnReturn}")  
    private boolean testOnReturn;  
    @Value("${spring.datasource.poolPreparedStatements}")  
    private boolean poolPreparedStatements;  
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;  
    @Value("${spring.datasource.filters}")  
    private String filters;  
    @Value("{spring.datasource.connectionProperties}")  
    private String connectionProperties;  
      
    /**
     * 然后当你手头拥有所有的配置信息之后
     * 就可以使用@Bean注解+方法的形式，在方法中基于加载进来的配置参数来创建你需要的各种bean
     * 将这个bean返回即可，这个bean就会被注册到spring容器中去
     * @return
     */
    @Bean     
    /**
     * 那么@Primary注解是啥意思呢？
     * 这个注解是这样子，你返回的这个是个DataSource类型的bean
     * spring在进行bean装配的时候，比如有其他某个类用@Autowired来要求装配一个DataSource bean
     * 但是此时如果你的应用中配置了多个DataSource类型的bean，那么此时装配会失败
     * 所以如果你在这个bean上标注一个@Primary，那么在出现多个同一类型的bean的时候，就会选择加了@Primary注解的bean
     * @return
     */
    @Primary  
    public DataSource dataSource(){  
        DruidDataSource datasource = new DruidDataSource();  
        datasource.setUrl(this.dbUrl);  
        datasource.setUsername(username);  
        datasource.setPassword(password);  
        datasource.setDriverClassName(driverClassName);  
        datasource.setInitialSize(initialSize);  
        datasource.setMinIdle(minIdle);  
        datasource.setMaxActive(maxActive);  
        datasource.setMaxWait(maxWait);          
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
        datasource.setValidationQuery(validationQuery);  
        datasource.setTestWhileIdle(testWhileIdle);  
        datasource.setTestOnBorrow(testOnBorrow);  
        datasource.setTestOnReturn(testOnReturn);  
        datasource.setPoolPreparedStatements(poolPreparedStatements);  
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
        
        try {  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
            e.printStackTrace();
        }  
        
        datasource.setConnectionProperties(connectionProperties);  
          
        return datasource;  
    }
    
}