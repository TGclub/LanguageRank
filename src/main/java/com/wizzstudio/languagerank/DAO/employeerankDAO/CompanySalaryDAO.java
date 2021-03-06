package com.wizzstudio.languagerank.DAO.employeerankDAO;

import com.wizzstudio.languagerank.domain.employeerank.CompanySalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanySalaryDAO extends JpaRepository<CompanySalary, Integer> {

    // 查询使用该语言的公司薪资排行前五名
    @Query(nativeQuery = true, value = "select * from company_salary where language_name = :languageName order by company_ord_salary DESC limit 5")
    List<CompanySalary> findTopFiveByLanguageName(@Param("languageName")String languagename);

    // 查询使用该语言的公司薪资排行前两名
    @Query(nativeQuery = true, value = "select * from company_salary where language_name = :languageName order by company_ord_salary DESC limit 2")
    List<CompanySalary> findTopTwoByLanguageName(@Param("languageName")String languagename);

    // 查询使用该语言的公司薪资排行前三名
    @Query(nativeQuery = true, value = "select * from company_salary where language_name = :languageName order by company_ord_salary DESC limit 3")
    List<CompanySalary> findTopThreeByLanguageName(@Param("languageName")String languagename);
}
