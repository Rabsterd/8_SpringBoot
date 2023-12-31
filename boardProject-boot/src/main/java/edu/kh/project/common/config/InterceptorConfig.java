package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Bean
	public BoardTypeInterceptor boardTypeInterceptor() {
		return new BoardTypeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor( boardTypeInterceptor() )
		.addPathPatterns("/**") // 가로챌 경로 지정(여러 개 작성 시 ,로 구분)
		.excludePathPatterns("/css/**", "/image/**", "/js/**"); // 가로채지 않을 경우
		
		/* 
		 * registry.addInterceptor( 다른 인터셉터() )
		   .addPathPatterns("/**") // 가로챌 경로 지정(여러 개 작성 시 ,로 구분)
		   .excludePathPatterns("/css/**", "/image/**", "/js/**"); // 가로채지 않을 경우	
		  */
	}
	
	
	
}
