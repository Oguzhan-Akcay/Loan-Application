package com.definex.loanapplication.repository;

import com.definex.loanapplication.entity.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {

    CreditScore findCreditScoreByUser_BirthdateAndUser_UserTc(String userTc, String birthdate);

 //   CreditScore findCreditScoreByUserUserId(Long userId);


}
