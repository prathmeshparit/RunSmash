package com.runsmash.web.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = {@JoinColumn(name = "user_id" , referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id" , referencedColumnName = "id")})

    private List<Role> roles = new ArrayList<>();
}
