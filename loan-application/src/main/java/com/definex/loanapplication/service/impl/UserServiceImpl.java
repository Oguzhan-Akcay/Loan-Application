package com.definex.loanapplication.service.impl;

import com.definex.loanapplication.dto.UserDto;
import com.definex.loanapplication.entity.User;
import com.definex.loanapplication.exception.*;
import com.definex.loanapplication.repository.UserRepository;
import com.definex.loanapplication.response.Meta;
import com.definex.loanapplication.response.UserResponse;
import com.definex.loanapplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Service method written for user registration
    public UserResponse register(UserDto userDto) throws RegisterException {
        User existingUser = userRepository.findUserByUserId(userDto.userId);
        if (existingUser != null) {
            throw new RegisterException();
        }
        User user = User.fromResource(userDto);
        user = userRepository.save(user);
        userDto.userId = user.getUserId();
        return createdUser(User.toResource(user));
    }

    //Service method with feedback on user information
    public UserResponse createdUser(UserDto toResourse) {
        UserResponse userResponse = new UserResponse();
        userResponse.meta = new Meta(2000, "Registration success. ");
        userResponse.userDto = toResourse;
        return userResponse;
    }

    //Service method written for user login
    public UserResponse login(UserDto userDto) throws LoginException {
        User user = userRepository.findUserByUserTcAndPassword(userDto.userTc, userDto.password);
        UserResponse userResponse = new UserResponse();
        if (user == null) {
            throw new LoginException();
        }
        userResponse.userDto=User.toResource(user);
        userResponse.authorizationTicket = Base64.getEncoder().encodeToString((userDto.getUserTc() + userDto.getPassword()).getBytes());
        userResponse.meta = new Meta(2000, "Login success. ");
        return userResponse;
    }

    @Override
    public Boolean authorizeUser(String ticket) {
        for (UserDto userDto : getAllUsers()){
            String targetTicket = Base64.getEncoder().encodeToString((userDto.getUserTc() + userDto.getPassword()).getBytes());
            if (ticket.equals(targetTicket)){
                return true;
            }
        }
        return false;
    }

    //Service method written for user deletion
    public void deleteUser(Long userId) {
        userRepository.delete(userRepository.findUserByUserId(userId));
    }

    //Service method written for updating user information
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setUserSurname(user.getUserSurname());
        existingUser.setUserTc(user.getUserTc());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setMonthlyIncome(user.getMonthlyIncome());
        existingUser.setBirthdate(user.getBirthdate());
        existingUser.setGuarentee(user.getGuarentee());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    //Service method written to list all users
    public List<UserDto> getAllUsers() {
        List<UserDto> listDto = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            UserDto userDto = User.toResource(user);
            listDto.add(userDto);
        }
        return listDto;
    }

    @Override
    public User getUserByUserId(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else new RuntimeException("User not found for id :: " + id);
        return user;
    }


    @Override
    public User getUserByUserBirthdateAndUserTc(String birthdate, String userTc) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findUserByUserTcAndBirthdate(birthdate, userTc));
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else new RuntimeException("User not found for tc :: " + userTc);
        return user;
    }





}


