package com.kodnest.tune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tune.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

  public User findByEmail(String email);

}
