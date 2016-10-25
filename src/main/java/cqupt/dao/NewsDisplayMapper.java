package cqupt.dao;

import cqupt.domain.NewsDisplay;

public interface NewsDisplayMapper {
    int insert(NewsDisplay record)throws Exception;

    int insertSelective(NewsDisplay record)throws Exception;
}