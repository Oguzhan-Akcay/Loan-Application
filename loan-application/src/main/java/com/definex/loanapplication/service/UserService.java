package com.definex.loanapplication.service;


import com.definex.loanapplication.dto.UserDto;
import com.definex.loanapplication.entity.User;
import com.definex.loanapplication.exception.*;
import com.definex.loanapplication.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse register(UserDto userDto) throws RegisterException;

    UserResponse login(UserDto userDto) throws LoginException;

    void deleteUser(Long userId);

    User updateUser(User user);

    List<UserDto> getAllUsers();
///////////////////////////////////

    User getUserByUserId(Long id);

    Boolean authorizeUser(String ticket);

    User getUserByUserBirthdateAndUserTc(String birthdate, String userTc);



}
