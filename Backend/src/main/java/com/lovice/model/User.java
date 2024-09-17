package com.lovice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lovice.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // provide teh getter setter method for the class using lombok
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Generate the ID Automatically for this Entity
    private Long id;

    private String fullName;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // password is only writable, whenever we fetch the user from client
    //// side we will ignore the password filed
    private String password;

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();


    private USER_ROLE role= USER_ROLE.ROLE_CUSTOMER; // we are making it a default role.


}
