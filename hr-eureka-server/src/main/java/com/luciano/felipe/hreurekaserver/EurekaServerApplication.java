package com.luciano.felipe.hreurekaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Bcrypt:" + passwordEnconder.encode("123456"));
	}

}
