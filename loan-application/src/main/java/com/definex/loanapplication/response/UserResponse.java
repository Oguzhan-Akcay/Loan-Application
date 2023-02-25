package com.definex.loanapplication.response;

import com.definex.loanapplication.dto.UserDto;
import java.io.Serializable;

public class UserResponse extends BaseResponse implements Serializable {
    public UserDto userDto;
    public String authorizationTicket;
}