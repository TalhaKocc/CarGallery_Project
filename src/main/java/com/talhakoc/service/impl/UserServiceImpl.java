package com.talhakoc.service.impl;

import org.springframework.stereotype.Service;

import com.talhakoc.model.User;
import com.talhakoc.repository.UserRepository;
import com.talhakoc.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;
	
	@Override
	public User findUser(String email) {
		
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new IllegalStateException("Kullanıcı Bulunamadı"));
		
		return user;
	}

}
