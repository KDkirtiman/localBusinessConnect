package com.lbc.localbusinessconnect;

import com.lbc.localbusinessconnect.config.LocalBusinessConnectConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(
		exclude = {DataSourceAutoConfiguration.class},
		scanBasePackages = {"com.lbc.localbusinessconnect.*"}
)
public class LocalbusinessconnectApplication {

	public static void main(String[] args) {
		//var applicationContext = new AnnotationConfigApplicationContext(LocalBusinessConnectConfiguration.class);
		System.setProperty("logging.config", "classpath:logback.xml");
		SpringApplication.run(LocalbusinessconnectApplication.class, args);
	}

}
