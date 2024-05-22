package com.runsmash.web.service;

import com.runsmash.web.dto.RegistrationDto;
import com.runsmash.web.models.UserEntity;

public interface UserService {
     public   UserEntity findEmail(String email) ;

     public UserEntity findUsername(String username) ;


    void saveUser(RegistrationDto registrationDto);
}
