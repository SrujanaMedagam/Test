package com.valuelabs.lms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.valuelabs.lms"})
@Import(DBConfig.class)
@EnableWebMvc
public class LmsConfiguration extends WebMvcConfigurerAdapter {
	@Bean  
    public InternalResourceViewResolver viewResolver() {  
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");
        return resolver;  
    }
	@Bean  
    public ResourceBundleViewResolver resourceBundleViewResolver() {  
	ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
	resolver.setOrder(1);
	resolver.setBasename("views");
        return resolver;  
    }
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/res/**").addResourceLocations("/res/");
	    registry.addResourceHandler("/app/**").addResourceLocations("/app/");
	}

}
