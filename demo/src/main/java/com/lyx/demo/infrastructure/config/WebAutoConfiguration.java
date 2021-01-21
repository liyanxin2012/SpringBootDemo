package com.lyx.demo.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * WebMvc Auto Configuration
 *
 * @author Ryan
 */
@Configuration
public class WebAutoConfiguration extends WebMvcConfigurationSupport {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 添加参数Resolvers
	 *
	 * @param argumentResolvers
	 */
	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
	}

	/**
	 * 添加拦截器
	 *
	 * @param registry
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// 添加拦截器
		super.addInterceptors(registry);
	}
}
