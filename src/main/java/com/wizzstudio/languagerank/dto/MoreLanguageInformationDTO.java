package com.wizzstudio.languagerank.dto;

/*
Created by Ben Wen on 2019/4/4.
*/

import com.wizzstudio.languagerank.domain.Company;
import com.wizzstudio.languagerank.domain.Language;
import com.wizzstudio.languagerank.enums.LanguageApplicationFieldsEnum;
import com.wizzstudio.languagerank.enums.LanguageUseEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MoreLanguageInformationDTO {
    private Language language;

    private List<LanguageApplicationFieldsEnum> languageApplicationFields;

    private List<LanguageUseEnum> languageUse;

    private List<Company> companyList;

    // 语言优点
    @NotNull
    private List<String> languageAdvantage;

    // 语言缺点
    @NotNull
    private List<String> languageDisadvantage;
}
