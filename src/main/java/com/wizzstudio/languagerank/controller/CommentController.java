package com.wizzstudio.languagerank.controller;

/*
Created by Ben Wen on 2019/4/24.
*/

import com.alibaba.fastjson.JSONObject;
import com.wizzstudio.languagerank.domain.EmployeeRank.EmployeeRankComment;
import com.wizzstudio.languagerank.domain.FixedRank.FixedRankComment;
import com.wizzstudio.languagerank.domain.User.User;
import com.wizzstudio.languagerank.enums.CommentDisplayModeEnum;
import com.wizzstudio.languagerank.service.CommentService;
import com.wizzstudio.languagerank.service.UserService;
import com.wizzstudio.languagerank.util.RedisUtil;
import com.wizzstudio.languagerank.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/getemployeerankcomment")
    public ResponseEntity getEmployeeRankComment(@RequestBody JSONObject jsonObject) {
        String languageName = jsonObject.getString("languageName");
        Integer pageIndex = jsonObject.getInteger("pageIndex");
//        Integer userId = jsonObject.getInteger("userId");
        Integer commentDisplayModeInteger = jsonObject.getInteger("commentDisplayMode");

        CommentDisplayModeEnum commentDisplayMode;
        // 1表示优先显示最新评论，2表示优先显示最先评论(默认为1)
        if (commentDisplayModeInteger == 1) {
            commentDisplayMode = CommentDisplayModeEnum.NEW_COMMENT_PRIORITIZED;
        } else {
            commentDisplayMode = CommentDisplayModeEnum.OLD_COMMENT_PRIORITIZED;
        }

//        CommentDisplayModeEnum commentDisplayMode = redisUtil.getUser(userId).getCommentDisplayMode();
        List<EmployeeRankComment> list;
        try {
             list =  commentService.getEmployeeRankComment(languageName, pageIndex, commentDisplayMode);
        } catch (Exception e) {
            log.error("获取雇主需求详情页的评论失败");
            e.printStackTrace();
            return ResultUtil.error();
        }
        log.info("获取雇主需求详情页的评论成功");
        return ResultUtil.success(list);
    }

    @PostMapping("getfixedrankcomment")
    public ResponseEntity getFixedRankComment(@RequestBody JSONObject jsonObject) {
        String languageName = jsonObject.getString("languageName");
        Integer pageIndex = jsonObject.getInteger("pageIndex");
//        Integer userId = jsonObject.getInteger("userId");
        Integer commentDisplayModeInteger = jsonObject.getInteger("commentDisplayMode");

        CommentDisplayModeEnum commentDisplayMode;
        if (commentDisplayModeInteger == 1) {
            commentDisplayMode = CommentDisplayModeEnum.NEW_COMMENT_PRIORITIZED;
        } else {
            commentDisplayMode = CommentDisplayModeEnum.OLD_COMMENT_PRIORITIZED;
        }

//        CommentDisplayModeEnum commentDisplayMode = redisUtil.getUser(userId).getCommentDisplayMode();
        List<FixedRankComment> list;
        try {
            list =  commentService.getFixedRankComment(languageName, pageIndex, commentDisplayMode);
        } catch (Exception e) {
            log.error("获取语言主页的评论失败");
            e.printStackTrace();
            return ResultUtil.error();
        }
        log.info("获取语言主页的评论成功");
        return ResultUtil.success(list);
    }

    @PostMapping("/updateemployeerankcomment")
    public ResponseEntity updateEmployeeRankComment(@RequestBody JSONObject jsonObject) {
        try {
            commentService.updateEmployeeRankComment(jsonObject);
        } catch (Exception e) {
            log.error("更新雇主需求详情页的评论失败");
            e.printStackTrace();
            return ResultUtil.error();
        }
        log.info("更新雇主需求详情页的评论成功");
        return ResultUtil.success();
    }

    @PostMapping("/updatefixedrankcomment")
    public ResponseEntity updateFixedRankComment(@RequestBody JSONObject jsonObject) {
        try {
            commentService.updateFixedRankComment(jsonObject);
        } catch (Exception e) {
            log.error("更新语言主页的评论失败");
            e.printStackTrace();
            return ResultUtil.error();
        }
        log.info("更新语言主页的评论成功");
        return ResultUtil.success();
    }

//    @PostMapping("/updatecommentdisplaymode")
//    public ResponseEntity updateCommentDisplayMode(@RequestBody JSONObject jsonObject) {
//        Integer commentDisplayModeInteger = jsonObject.getInteger("commentDisplayMode");
//        Integer userId = jsonObject.getInteger("userId");
//        CommentDisplayModeEnum commentDisplayMode;
//
//        // 1表示优先显示最新评论，2表示优先显示最先评论
//        if (commentDisplayModeInteger == 1) {
//            commentDisplayMode = CommentDisplayModeEnum.NEW_COMMENT_PRIORITIZED;
//        } else {
//            commentDisplayMode = CommentDisplayModeEnum.OLD_COMMENT_PRIORITIZED;
//        }
//        try {
//            userService.updateCommentDisplayMode(commentDisplayMode, userId);
//        } catch (Exception e) {
//            log.error("更新用户评论显示顺序失败");
//            e.printStackTrace();
//            return ResultUtil.error();
//        }
//
//        log.info("更新用户评论显示顺序成功");
//        User user = redisUtil.getUser(userId);
//        user.setCommentDisplayMode(commentDisplayMode);
//        redisUtil.setUser(userId, user);
//
//        return ResultUtil.success();
//    }
}