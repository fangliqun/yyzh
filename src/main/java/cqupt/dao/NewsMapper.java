package cqupt.dao;

import cqupt.domain.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(News record)throws Exception;

    int insertSelective(News record)throws Exception;

    News selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(News record)throws Exception;

    int updateByPrimaryKey(News record)throws Exception;
}