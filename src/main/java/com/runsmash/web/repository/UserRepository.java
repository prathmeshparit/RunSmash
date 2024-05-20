package com.runsmash.web.repository;

import com.runsmash.web.models.Role;
import com.runsmash.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);

}
