package com.myproject.technicaltest.serviceImpl;

import java.util.Optional;

import com.myproject.technicaltest.Mapper.UserMapper;
import com.myproject.technicaltest.dto.UserDto;
import org.springframework.stereotype.Service;

import com.myproject.technicaltest.entity.User;
import com.myproject.technicaltest.repository.UserRepository;
import com.myproject.technicaltest.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        // TODO Auto-generated constructor stub
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(UserDto user) {
        User userToPersit = this.userMapper.asUser(user);
        return userRepository.save(userToPersit);
    }


}