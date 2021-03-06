package com.wizzstudio.languagerank.controller;

/*
Created by Ben Wen on 2019/3/22.
*/

import com.wizzstudio.languagerank.DAO.LanguageDAO;
import com.wizzstudio.languagerank.VO.LanguageMessageVO;
import com.wizzstudio.languagerank.domain.employeerank.CompanyPost;
import com.wizzstudio.languagerank.domain.employeerank.CompanySalary;
import com.wizzstudio.languagerank.domain.employeerank.LanguageCity;
import com.wizzstudio.languagerank.VO.LanguagePostVO;
import com.wizzstudio.languagerank.domain.employeerank.LanguagePost;
import com.wizzstudio.languagerank.service.EmployeeRankService;
import com.wizzstudio.languagerank.service.EmployeeService;
import com.wizzstudio.languagerank.service.PosterService;
import com.wizzstudio.languagerank.util.ResultUtil;
import jdk.nashorn.internal.objects.annotations.Getter;
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
    EmployeeService employeeService;
    @Autowired
    EmployeeRankService employeeRankService;
    @Autowired
    PosterService posterService;

    /**
     * 查询与该语言相关的基本信息接口(两榜共用)
     */
    @GetMapping("/{languageName}/message")
    public ResponseEntity getLanguageMessage(@PathVariable("languageName")String languageName) {
        try {
            LanguageMessageVO languageMessage = employeeService.getLanguageMessage(languageName);

            log.info("获取与"+ languageName + "相关的基本信息成功");
            return ResultUtil.success(languageMessage);
        } catch (Exception e) {
            log.error("获取与"+ languageName + "相关的基本信息失败");
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("/{languageName}/post")
    public ResponseEntity getLanguagePost(@PathVariable("languageName")String languageName) {
        try {
            List<LanguagePost> languagePostList = employeeService.getLanguagePost(languageName);

            log.info("获取与"+ languageName + "相关的热门岗位排行成功");
            return ResultUtil.success(languagePostList);
        } catch (Exception e) {
            log.error("获取与"+ languageName + "相关的热门岗位排行失败");
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("/{languageName}/salary")
    public ResponseEntity getCompanySalary(@PathVariable("languageName")String languageName) {
        List<CompanySalary> list = employeeService.getCompanySalary(languageName);
        if (list != null) {
            log.info("获取使用"+ languageName +"的公司薪资排行成功");
            return ResultUtil.success("获取使用"+ languageName +"的公司薪资排行成功", list);
        } else {
            log.error("获取使用"+ languageName +"的公司薪资排行失败");
            return ResultUtil.error("获取使用"+ languageName +"的公司薪资排行失败");
        }
    }

    @GetMapping("/{languageName}/companypost")
    public ResponseEntity getCompanyPost(@PathVariable("languageName")String languageName) {
        List<CompanyPost> list = employeeService.getCompanyPost(languageName);
        if (list != null) {
            log.info("获取使用"+ languageName +"的公司岗位需求量排行成功");
            return ResultUtil.success("获取使用"+ languageName +"的公司岗位需求量排行成功", list);
        } else {
            log.error("获取使用"+ languageName +"的公司岗位需求量排行失败");
            return ResultUtil.error("获取使用"+ languageName +"的公司岗位需求量排行失败");
        }
    }

    @GetMapping("/{languageName}/languagecity")
    public ResponseEntity getLanguageCity(@PathVariable("languageName")String languageName) {
        List<LanguageCity> list = employeeService.getLanguageCity(languageName);
        if (list != null) {
            log.info("查询几大城市对"+ languageName +"的需求量成功");
            return ResultUtil.success("查询几大城市对"+ languageName +"的需求量成功", list);
        } else {
            log.error("查询几大城市对"+ languageName +"的需求量失败");
            return ResultUtil.error("查询几大城市对"+ languageName +"的需求量失败");
        }
    }

    @GetMapping("/employerdemandrank")
    public ResponseEntity getEmployeeRank(){
        log.info("获取雇主需求榜榜单页成功");
        return ResultUtil.success(employeeRankService.getEmployeeRank());
    }

    @GetMapping("/saveexponent")
    public ResponseEntity saveExponent() {
        employeeRankService.saveExponent();
        return ResultUtil.success();
    }
}
