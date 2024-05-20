package com.runsmash.web.impl;

import com.runsmash.web.dto.RegistrationDto;
import com.runsmash.web.models.Role;
import com.runsmash.web.models.UserEntity;
import com.runsmash.web.repository.RoleRepository;
import com.runsmash.web.repository.UserRepository;
import com.runsmash.web.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserServiceImpl  implements UserService
{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {

        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
