package com.myproject.technicaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.technicaltest.entity.User;

/**
 * UserRepository interface to perform CRUD operations.
 * @author Yasmine MANSOURI
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}