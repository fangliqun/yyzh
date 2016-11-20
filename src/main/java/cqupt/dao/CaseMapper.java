package cqupt.dao;

import java.util.List;

import cqupt.domain.Case;

public interface CaseMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(Case record)throws Exception;
    
    List<String> selectAllCaseName()throws Exception;

    Case selectByPrimaryKey(Integer id)throws Exception;

    int update(Case record)throws Exception;

    int updateByPrimaryKey(Case record)throws Exception;
    
    List<Case> selectCaseByPage(int page)throws Exception;
    
    Case selectCaseInfo(String title)throws Exception;
    
    String selectSbContentById(int id)throws Exception;
    
    int delete(int id)throws Exception;
}