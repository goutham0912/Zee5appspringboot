package com.zee.zee5app.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository repository;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("invalid username"));
		
		return UserDetailsImpl.build(user);
	}

}
