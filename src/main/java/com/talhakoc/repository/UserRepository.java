package com.talhakoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talhakoc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
