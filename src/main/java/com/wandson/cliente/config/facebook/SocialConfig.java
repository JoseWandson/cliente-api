package com.wandson.cliente.config.facebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
public class SocialConfig {

	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator(Environment environment) {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();

		registry.addConnectionFactory(
				new FacebookConnectionFactory(environment.getProperty("spring.social.facebook.appId"),
						environment.getProperty("spring.social.facebook.appSecret")));
		return registry;
	}

	@Bean
	public UsersConnectionRepository usersConnectionRepository(Environment environment) {
		return new InMemoryUsersConnectionRepository(connectionFactoryLocator(environment));
	}

}
