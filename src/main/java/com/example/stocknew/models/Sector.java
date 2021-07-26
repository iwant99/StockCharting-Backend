package com.example.stocknew.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Sector {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(targetEntity = Company.class, cascade = CascadeType.ALL, mappedBy = "sector")
    private List<Company> companyList;
    private String brief;
}
