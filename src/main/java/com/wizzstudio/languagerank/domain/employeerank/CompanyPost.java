package com.wizzstudio.languagerank.domain.employeerank;

/*
Created by Ben Wen on 2019/3/19.
*/

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

// 雇主需求详情页面第三部分
@Data
@Entity
public class CompanyPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String languageName;

    @NotNull
    private String companyName;

    @NotNull
    private Integer companyPostNumber;
}
