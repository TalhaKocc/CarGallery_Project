package com.talhakoc.service.impl;

import org.springframework.stereotype.Service;

import com.talhakoc.model.Role;
import com.talhakoc.repository.RoleRepository;
import com.talhakoc.service.IRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService{
	
	private final RoleRepository roleRepository;
	
	@Override
	public Role findByName(String name) {
		
		Role role = roleRepository.findByName(name)
				.orElseThrow(() -> new IllegalStateException("Rol bulunamadı"));
		
		return role;
	}

	
}
