package com.valuelabs.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableTransactionManagement
//@PropertySource("classpath:database.properties","classpath:database2.properties")
@PropertySources({
    @PropertySource("classpath:database.properties")
})
public class DBConfig {
        @Autowired
        private Environment env;
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate= new HibernateTemplate(sessionFactory());
		hibernateTemplate.setCheckWriteOperations(false);
		return hibernateTemplate;
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDataSource());
		lsfb.setPackagesToScan("com.valuelabs");
		lsfb.setHibernateProperties(hibernateProperties()); 
		try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb.getObject();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver_class"));
	    dataSource.setUrl(env.getProperty("database.connection.url"));
	    dataSource.setUsername(env.getProperty("hibernate.connection.username"));
	    dataSource.setPassword(env.getProperty("hibernate.connection.password"));
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
        private Properties hibernateProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
            properties.put("hibernate.hbm2ddl.auto", env.getProperty("hbm2ddl.auto"));
            properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
            properties.put("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
            properties.put("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
            properties.put("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
            properties.put("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
            properties.put("hibernate.c3p0.idle_test_period", env.getProperty("hibernate.c3p0.idle_test_period"));
            
            return properties;        
       }	
} 