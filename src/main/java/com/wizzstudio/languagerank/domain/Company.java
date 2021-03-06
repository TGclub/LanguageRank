package com.wizzstudio.languagerank.domain;

/*
Created by Ben Wen on 2019/4/4.
*/

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String companyName;

    @NotNull
    private String companySymbol;
}
