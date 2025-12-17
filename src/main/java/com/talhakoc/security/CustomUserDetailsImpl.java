package com.talhakoc.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.talhakoc.model.User;
import com.talhakoc.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component                                                          // spring içinde bean oluşturmak için kullanıyoruz 
@RequiredArgsConstructor
public class CustomUserDetailsImpl implements UserDetails {
	
	private UserRepository userRepository;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	