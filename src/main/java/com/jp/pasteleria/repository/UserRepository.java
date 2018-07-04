package com.jp.pasteleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.pasteleria.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
