
package com.codetest.audio.audiotest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@Async
@EnableWebMvc
public class WebMVCConfiguration
		implements WebMvcConfigurer{


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// registry.addMapping("/**").allowedOrigins("*");
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowCredentials(false);

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		registry.addResourceHandler("/api/v1/generated/audio/**").addResourceLocations("file:" + s + "/generated/");
		registry.addResourceHandler("/api/v1/audio/**").addResourceLocations("file:" + s + "/audio/")
		.setCachePeriod(120).resourceChain(true);
		
	}


	@Bean(name = "threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}

}
