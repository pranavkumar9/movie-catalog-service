package com.pks.movie_catalog_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MovieServiceConfig {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()

	{
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(2000);
		clientHttpRequestFactory.setReadTimeout(2000);
		return new RestTemplate(clientHttpRequestFactory);
//		return new RestTemplate();
	}
}
