package com.wizzstudio.languagerank.constants;

/*
Created by Ben Wen on 2019/3/16.
*/

public interface Constant {
    /**
     * redis用户缓存过期时间30分钟(1800秒)
     */
    Integer TOKEN_EXPIRED = 1800;

    String TOKEN = "token";

    String[] STUDY_PLAN_LANGUAGE = {"Java", "Python", "PHP", "C", "C++", "JavaScript"};

    /**
     * 班级标签
     */
    String[] CLAZZ_TAG = {"Java", "Python", "C", "C++", "JavaScript", "PHP"};

    /**
     * 评论一页显示几条
     */
    Integer COMMENT_PAGE_SIZE = 20;

    /**
     * 人气排行、勤奋排行与班级所有成员一页显示几条
     */
    Integer RANK_PAGE_SIZE = 20;

    /**
     * 微信模板消息Id
     */
    String TEMPLATE_ID = "9ttE1_oi6s6s7woxAAuGwWtlY1H0RPG26clRX4i-vek";

    /**
     * 点击微信模板跳转的路径
     */
    String PAGE_PATH = "";

    /**
     * 用户每天可获取积分上限
     */
    Integer SCORE_UPPER_LIMIT_TODAY = 300;
}
