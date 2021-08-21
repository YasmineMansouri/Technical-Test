package com.myproject.technicaltest.Mapper;

import com.myproject.technicaltest.dto.UserDto;
import com.myproject.technicaltest.entity.User;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * UserMapper interface to map the DTO to the Entity.
 * @author Yasmine MANSOURI
 *
 */

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface UserMapper {

    UserDto asUserDto(User user);

    User asUser(UserDto user);
}
