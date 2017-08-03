package com.caozhenjieproject.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

//@Configuration
public class DatasourceConfigurationTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
//	@Bean	
//	@Primary
//	@Profile("dev")
//	public DataSource dataSourceDev() throws Exception {
//		int i=0;
//		logger.debug("there has going to this function >>>>>>>>>>>>>>>>>>>>>>>>>>>>{[]}", i);
//		String driverClass = "com.mysql.jdbc.Driver";
//		
//		String jdbcUrl ="jdbc:mysql://127.0.0.1:3306/girl";
//		
//		DataSource dataSource = new DataSource();
//		dataSource.setUsername("root");
//		dataSource.setUrl(jdbcUrl);
//		dataSource.setDriverClassName(driverClass);	
//		return dataSource;
//	}
	
	
	
	
	
//	@Bean	
//	@Primary
//	@Profile("prod")
//	public DataSource dataSourceProd() throws Exception {
//		int i=0;
//		logger.debug("there has going to this function {[]}", i);
//		String driverClass = "com.mysql.jdbc.Driver";
//		
//		String jdbcUrl ="jdbc:mysql://127.0.0.1:3306/girl";
//		
//		DataSource dataSource = new DataSource();
//		dataSource.setUsername("root");
//		dataSource.setUrl(jdbcUrl);
//		dataSource.setDriverClassName(driverClass);	
//		return dataSource;
//	}

	
}
