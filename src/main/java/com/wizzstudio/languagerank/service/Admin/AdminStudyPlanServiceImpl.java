package com.wizzstudio.languagerank.service.Admin;

import com.wizzstudio.languagerank.DAO.employeerankDAO.EmployeeRankDAO;
import com.wizzstudio.languagerank.domain.employeerank.EmployeeRank;
import com.wizzstudio.languagerank.DTO.admin.AdminStudyPlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminStudyPlanServiceImpl implements AdminStudyPlanService {

    @Autowired
    EmployeeRankDAO employeeRankDAO;

    private List<AdminStudyPlanDTO> adminStudyPlanDTOList = new ArrayList<>();

    @Override
    public List<AdminStudyPlanDTO> getAdminStudyPlan() {

        List<EmployeeRank> employeeRanks = employeeRankDAO.findTopTenLanguage();
        for (EmployeeRank employeeRank : employeeRanks){
            AdminStudyPlanDTO adminStudyPlanDTO  =  new AdminStudyPlanDTO();
            String languageName = employeeRank.getLanguageName();

            adminStudyPlanDTO.setLanguageName(languageName);
//            adminStudyPlanDTO.setIncreaseNumber(languageCountService.findJoinedNumberByLanguage(languageName)[1]);
//            adminStudyPlanDTO.setNumber(languageCountService.findJoinedNumberByLanguage(languageName)[0]);

            adminStudyPlanDTOList.add(adminStudyPlanDTO);
        }

        return adminStudyPlanDTOList;
    }
}
