package com.talhakoc.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.talhakoc.model.Role;
import com.talhakoc.model.User;

public class CustomUserDetails implements UserDetails{

	private User user;
	Collection<? extends GrantedAuthority> authorities;
	
	public CustomUserDetails(User user) {
		this.user = user;
		
		Role role = user.getRole();
		this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
        return user.getEmail();
	}

	@Override
	public String getPassword() {
        return user.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {

        return user.isEnabled();
	}
	
	public User getUser() {
        return user;
	}
}
