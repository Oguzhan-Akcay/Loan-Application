package com.definex.loanapplication.service;

import com.definex.loanapplication.dto.CreditScoreDto;
import com.definex.loanapplication.dto.UserDto;
import com.definex.loanapplication.entity.User;
import com.definex.loanapplication.response.CreditScoreResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CreditScoreService {


    CreditScoreResponse addCredit(CreditScoreDto creditScoreDto);

    User makeAnApplication(String birthdate, String userTc);

    List<CreditScoreDto> getAllCredits();



}
