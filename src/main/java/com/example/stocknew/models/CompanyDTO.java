package com.example.stocknew.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {
    @NotNull
    @Size(min = 5)
    private String name;
    @NotNull
    private long sectorId;
    @NotNull
    private Long code;
    private float turnover;
    private String ceo;
    private String brief;
}
