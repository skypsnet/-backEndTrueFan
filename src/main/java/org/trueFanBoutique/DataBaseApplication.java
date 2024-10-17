package org.trueFanBoutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.trueFanBoutique.config.JwtFilter;

@SpringBootApplication
public class DataBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}//metodo main
		
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
			registrationBean.setFilter(new JwtFilter());
			registrationBean.addUrlPatterns("/truefan/productos/*");
			registrationBean.addUrlPatterns("/truefan/usuarios/*");
			registrationBean.addUrlPatterns("/truefan/order/*");
		return registrationBean;
	}//jwtFilter

}//class DataBaseApplication
