package cqupt.dao;

import java.util.List;

import cqupt.domain.CaseDisplay;

public interface CaseDisplayMapper {
    int deleteByPrimaryKey(Integer caseId)throws Exception;

    int insert(CaseDisplay record)throws Exception;

    int insertSelective(CaseDisplay record)throws Exception;

    List<CaseDisplay> selectByPrimaryKey(Integer caseId)throws Exception;

    int updateByPrimaryKeySelective(CaseDisplay record)throws Exception;

    int updateByPrimaryKey(CaseDisplay record)throws Exception;
}