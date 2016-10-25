package cqupt.dao;

import cqupt.domain.SpNews;

public interface SpNewsMapper {
    int deleteByPrimaryKey(Integer newsid)throws Exception;

    int insert(SpNews record)throws Exception;

    int insertSelective(SpNews record)throws Exception;
}