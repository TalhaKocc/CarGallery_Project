package com.talhakoc.security;

import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.talhakoc.model.User;
import com.talhakoc.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component                                                          // spring içinde bean oluşturmak için kullanıyoruz 
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.debug("loadUserByUsername çağrıldı: {}", username);
		User user = userRepository.findByEmail(username);
		if (user == null ) {
			logger.error("Kullanıcı Bulunamadı" + username);
			throw new UsernameNotFoundException("kullanıcı bulunamadı");
		}
		logger.info("Kullanıcı başarıyla bulundu");
		return new CustomUserDetails(user);
	}

	
}

	