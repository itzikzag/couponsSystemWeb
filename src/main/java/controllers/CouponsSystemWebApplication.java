package controllers;



import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import filter.AFilter;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CouponsSystemWebApplication {
	private @Autowired AutowireCapableBeanFactory beanFilter;
	public static void main(String[] args) {
		SpringApplication.run(CouponsSystemWebApplication.class, args);
		
	}
	@Bean
	public FilterRegistrationBean SessionAuthenticationFilter() {
		FilterRegistrationBean filterR = new FilterRegistrationBean();
		Filter filter = new AFilter();
		beanFilter.autowireBean(filter);

		filterR.setFilter(filter);
		filterR.addUrlPatterns("/couponsSystemWeb/admin/*");
		filterR.addUrlPatterns("/couponsSystemWeb/company/*");
		filterR.addUrlPatterns("/couponsSystemWeb/customer/*");
		filterR.addUrlPatterns("/couponsSystemWeb/logger/*");
		return filterR;
	}
	
}