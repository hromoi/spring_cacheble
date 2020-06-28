package main.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@ComponentScan(basePackages = "main")
@Configuration
public class ConfigurationApp {
}
