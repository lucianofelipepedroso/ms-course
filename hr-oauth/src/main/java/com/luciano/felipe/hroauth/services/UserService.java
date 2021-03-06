package com.luciano.felipe.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luciano.felipe.hroauth.entities.User;
import com.luciano.felipe.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if(user==null) {
			logger.error("E-mail not found: " + email);
			throw new IllegalArgumentException("E-mail not found");
		}
			logger.info("E-mail found: " + email);
		return user;
	}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(userName).getBody();
		if(user==null) {
			logger.error("E-mail not found: " + userName);
			throw new UsernameNotFoundException ("E-mail not found");
		}
			logger.info("E-mail found: " + userName);
		return user;
	}

}
