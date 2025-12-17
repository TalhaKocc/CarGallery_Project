package com.talhakoc.service;

import com.talhakoc.model.User;

public interface IUserService {

	User findUser(String email);
}
