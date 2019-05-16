package com.wizzstudio.languagerank.service;

/*
Created by Ben Wen on 2019/3/9.
*/

import com.wizzstudio.languagerank.VO.WxLogInVO;
import com.wizzstudio.languagerank.domain.user.User;
import com.wizzstudio.languagerank.DTO.WxInfoDTO;
import me.chanjar.weixin.common.error.WxErrorException;

public interface UserService {

    /**
     * 用户登录
     * @param loginData 用户登录临时凭证code
     * @return 用户openId与session_key
     */
    WxLogInVO userLogin(WxInfoDTO loginData) throws WxErrorException;

    /**
     * 新增用户信息
     *
     * @param openId 用户openId
     */
    User saveUser(String openId, String nickName, String avatarUrl);

    /**
     * 通过openId获取用户信息
     *
     * @param openId 用户openId
     */
    User findByOpenId(String openId);

    /**
     * 通过openId获取用户信息
     *
     * @param userId 用户userId
     */
    User findByUserId(Integer userId);

//    /**
//     * 当用户已完成今天学习计划(已登录过)后更新studyPlanDay
//     */
//    StudyPlanDayEnum updateStudyPlanDay(user user);
//
//    /**
//     * 更新用户个人主页上的语言
//     * @param chosenLanguage 用户新选择的语言
//     */
//    void updateMyLanguage(user user, String chosenLanguage);
//
    /**
     * 更新某用户今日登录情况
     */
    void updateIsLogInToday(Integer userId);
//
//    /**
//     * 更新用户转发表
//     */
//    void updateUserTranspondTable(user user, Integer studyPlanDay);

    /**
     * 关闭加入我的小程序弹窗
     */
    void updateIsViewedJoinMyApplet(Integer userId);

//    /**
//     * 更改用户显示评论的顺序
//     */
//    void updateCommentDisplayMode(CommentDisplayModeEnum commentDisplayMode, Integer userId);

//    /**
//     * 获取用户转发表
//     */
//    List<Boolean> getUseTranspond(String languageName, Integer userId);
//
//    /**
//     * 查询用户已学完的语言并返回其奖励
//     */
//    List<Award> findStudyedLanguageAwardByUserId(user user);
}
