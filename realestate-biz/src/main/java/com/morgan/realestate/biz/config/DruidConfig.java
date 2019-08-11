package com.morgan.realestate.biz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;

@Configuration
public class DruidConfig {

	@ConfigurationProperties(prefix = "spring.druid")
	@Bean(initMethod="init",destroyMethod="close")
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setProxyFilters(Lists.newArrayList(startFilter()));
		return dataSource;
	}
	
	@Bean
	public Filter startFilter() {
		StatFilter filter = new StatFilter();
		filter.setSlowSqlMillis(1);
		filter.setLogSlowSql(true);
		filter.setMergeSql(true);
		return filter;
	}
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
	}
}
