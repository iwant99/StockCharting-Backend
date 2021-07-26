package com.example.stocknew.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    @Email
    private String emailId;
    @NotNull
    private String mobile;
}
