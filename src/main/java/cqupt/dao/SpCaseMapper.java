package cqupt.dao;

import cqupt.domain.SpCase;

public interface SpCaseMapper {
    int deleteByPrimaryKey(Integer caseid)throws Exception;

    int insert(SpCase record)throws Exception;

    int insertSelective(SpCase record)throws Exception;

    SpCase selectByPrimaryKey(Integer caseid)throws Exception;

    int updateByPrimaryKeySelective(SpCase record)throws Exception;

    int updateByPrimaryKey(SpCase record)throws Exception;
}