package com.wizzstudio.languagerank.service;

/*
Created by Ben Wen on 2019/4/24.
*/

import com.alibaba.fastjson.JSONObject;
import com.wizzstudio.languagerank.VO.CommentVO;
import com.wizzstudio.languagerank.enums.CommentDisplayModeEnum;

import java.util.Map;

public interface CommentService {
    /**
     * 获取雇主需求详情页的评论
     */
    CommentVO getEmployeeRankComment(String languageName, Integer pageIndex, CommentDisplayModeEnum commentDisplayMode);

    /**
     * 获取语言主页的评论
     */
    CommentVO getFixedRankComment(String languageName, Integer pageIndex, CommentDisplayModeEnum commentDisplayMode);

    /**
     * 获取班级评论
     */
    CommentVO getClazzComment(Integer clazzId, Integer pageIndex, CommentDisplayModeEnum commentDisplayMode);

    /**
     * 新增雇主需求详情页的评论
     */
    void updateEmployeeRankComment(JSONObject jsonObject);

    /**
     * 新增语言主页的评论
     */
    void updateFixedRankComment(JSONObject jsonObject);

    /**
     * 新增班级评论
     */
    void updateClazzComment(JSONObject jsonObject);
}
