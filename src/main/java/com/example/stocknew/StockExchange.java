package com.example.stocknew;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StockExchange {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    private String street;
    private String state;
    private String country;
    private String brief;
    private String remarks;
}
