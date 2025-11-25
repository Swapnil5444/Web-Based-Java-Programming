package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"first","second","config"})
public class SpringAppConfig {
	//Bean declaration using @Bean if any(Java Based Configuration)
	
}
