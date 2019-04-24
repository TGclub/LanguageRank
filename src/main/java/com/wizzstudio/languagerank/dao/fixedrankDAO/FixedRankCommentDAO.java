package com.wizzstudio.languagerank.dao.fixedrankDAO;

/*
Created by Ben Wen on 2019/4/24.
*/

import com.wizzstudio.languagerank.domain.FixedRank.FixedRankComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FixedRankCommentDAO extends JpaRepository<FixedRankComment, Integer>, JpaSpecificationExecutor<FixedRankComment> {
}