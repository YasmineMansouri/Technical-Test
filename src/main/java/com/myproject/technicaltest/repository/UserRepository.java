package com.myproject.technicaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.technicaltest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}