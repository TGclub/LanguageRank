package com.wizzstudio.languagerank.service;

import com.wizzstudio.languagerank.domain.FixedFinalExponent;
import com.wizzstudio.languagerank.dto.FinalRankDTO;

import java.util.List;

public interface FixedRankService {

    /**
     * 每天零点计算并保存语言热度榜的最终指数
     */
    void saveExponent();

    /**
     * 获取语言热度榜四个字段
     */
    List<FinalRankDTO> getFinalRank();

    /**
     * 每日更新一次list（缓存用）
     */
    void resetList();
}
