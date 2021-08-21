package com.myproject.technicaltest.serviceImpl;

import java.util.Optional;

import com.myproject.technicaltest.Mapper.UserMapper;
import com.myproject.technicaltest.dto.UserDto;
import org.springframework.stereotype.Service;

import com.myproject.technicaltest.entity.User;
import com.myproject.technicaltest.repository.UserRepository;
import com.myproject.technicaltest.service.UserService;

/**
 * UserServiceImpl class to implement the methods defined in UserService.
 * @author Yasmine MANSOURI
 *
 */

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * getUserById to display the details of a registred user.
     *
     * @param  id of the user
     * @return user with the given id
     *
     */

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * saveUser to register a user.
     *
     * @param  user
     * @return User : the registered user
     *
     */

    @Override
    public User saveUser(UserDto user) {
        User userToPersit = this.userMapper.asUser(user);
        return userRepository.save(userToPersit);
    }

    /**
     * updateUser to update a user.
     *
     * @param  user
     * @return User : the updated user
     *
     */

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * deleteUser to delete a user.
     *
     * @param  id
     *
     */

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}