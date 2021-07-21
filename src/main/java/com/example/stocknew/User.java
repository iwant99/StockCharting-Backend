package com.example.stocknew;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String emailId;
    @Column(unique = true,nullable = false)
    private String mobile;
    @Column(nullable = false)
    private boolean isAdmin;
}
