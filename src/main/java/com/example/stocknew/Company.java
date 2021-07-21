package com.example.stocknew;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private Long code;
    private float turnover;
    private String ceo;
    private String brief;
    @Column(unique = true,nullable = false)
    private String name;
    @ManyToOne
    private Sector sector;



}
