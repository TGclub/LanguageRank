package com.wizzstudio.languagerank.service.impl;

/*
Created by Ben Wen on 2019/3/12.
*/

import com.wizzstudio.languagerank.dao.LanguageDAO;
import com.wizzstudio.languagerank.domain.LanguageCount;
import com.wizzstudio.languagerank.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageDAO languageDAO;

    // 当前总人数为number与increaseNumber之和
    @Override
    public Integer findJoinedNumberByLanguage(String languageName) {
        return languageDAO.findByLanguageName(languageName).getNumber()+languageDAO.findByLanguageName(languageName).getIncreaseNumber();
    }

    @Override
    public Integer findJoinedTodayByLanguage(String languageName) {
        return languageDAO.findByLanguageName(languageName).getIncreaseNumber();
    }

    @Override
    public void updateNumber(Integer increaseNumber, String languageName) {

    }
}