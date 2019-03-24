package com.wizzstudio.languagerank.controller;

/*
Created by Ben Wen on 2019/3/22.
*/

import com.wizzstudio.languagerank.domain.CompanyPost;
import com.wizzstudio.languagerank.domain.CompanySalary;
import com.wizzstudio.languagerank.domain.LanguageCity;
import com.wizzstudio.languagerank.domain.LanguagePost;
import com.wizzstudio.languagerank.service.EmployeeService;
import com.wizzstudio.languagerank.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{languageName}/post")
    public ResponseEntity getLanguagePost(@PathVariable("languageName")String languageName) {
        List<LanguagePost> list =  employeeService.getLanguagePost(languageName);
        if (list != null) {
            log.info("获取与该语言相关的热门岗位排行成功");
            return ResultUtil.success(list);
        } else {
            log.error("获取与该语言相关的热门岗位排行失败");
            return ResultUtil.error("获取与该语言相关的热门岗位排行失败");
        }
    }

    @GetMapping("/{languageName}/salary")
    public ResponseEntity getCompanySalary(@PathVariable("languageName")String languageName) {
        List<CompanySalary> list = employeeService.getCompanySalary(languageName);
        if (list != null) {
            log.info("获取使用该语言的公司薪资排行成功");
            return ResultUtil.success(list);
        } else {
            log.error("获取使用该语言的公司薪资排行失败");
            return ResultUtil.error("获取使用该语言的公司薪资排行失败");
        }
    }

    @GetMapping("/{languageName}/companypost")
    public ResponseEntity getCompanyPost(@PathVariable("languageName")String languageName) {
        List<CompanyPost> list = employeeService.getCompanyPost(languageName);
        if (list != null) {
            log.info("获取使用该语言的公司岗位需求量排行成功");
            return ResultUtil.success(list);
        } else {
            log.error("获取使用该语言的公司岗位需求量排行失败");
            return ResultUtil.error("获取使用该语言的公司岗位需求量排行失败");
        }
    }

    @GetMapping("/{languageName}/languagecity")
    public ResponseEntity getLanguageCity(@PathVariable("languageName")String languageName) {
        List<LanguageCity> list = employeeService.getLanguageCity(languageName);
        if (list != null) {
            log.info("查询几大城市对该语言的需求量成功");
            return ResultUtil.success(list);
        } else {
            log.error("查询几大城市对该语言的需求量失败");
            return ResultUtil.error("查询几大城市对该语言的需求量失败");
        }
    }
}