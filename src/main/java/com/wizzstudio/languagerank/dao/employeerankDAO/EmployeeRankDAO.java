package com.wizzstudio.languagerank.dao.employeerankDAO;

import com.wizzstudio.languagerank.domain.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRankDAO extends JpaRepository<EmployeeRank, Integer> {

//    @Query("select e from EmployeeRank e where e.languageName = :languageName and e.updateTime = ")
    EmployeeRank findByLanguageName(@Param("languageName") String languageName);

    // 排序前十语言
    @Query(nativeQuery = true,value = "select * from employee_rank where update_time =" +
            " (select update_time from employee_rank order by update_time DESC limit 1)" +
            " order by employee_final_exponent DESC limit 10")
    List<EmployeeRank> findTopTenLanguage();

    // 比较LanguageTend时使用
    @Query(nativeQuery = true,value = "select * from employee_rank where language_name = :languageName  " +
            "order by employee_final_exponent DESC limit 2")
    List<EmployeeRank> findTwoByLanguageName(@Param("languageName")String languageName);
}