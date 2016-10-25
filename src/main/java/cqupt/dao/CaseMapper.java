package cqupt.dao;

import java.util.List;

import cqupt.domain.Case;

public interface CaseMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(Case record)throws Exception;

    int insertSelective(Case record)throws Exception;

    Case selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(Case record)throws Exception;

    int updateByPrimaryKey(Case record)throws Exception;
    
    List<Case> selectCaseByPage(int page)throws Exception;
}