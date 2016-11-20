package cqupt.dao;

import java.util.List;

import cqupt.domain.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(News news)throws Exception;
    
    List<String> selectAllNewsName()throws Exception;

    int insertSelective(News record)throws Exception;

    News selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(News record)throws Exception;

    int updateByPrimaryKey(News record)throws Exception;
    
    List<News> selectNewsFirst()throws Exception;
    
    List<News> selectNewsMore(int page)throws Exception;
    
    News selectNewsInfo(String title)throws Exception;
    
    int update(News news)throws Exception;
    
    int delete(int id)throws Exception;
    
    News selectNewsById(int id )throws Exception;
    
    String selectSbContentById(int id )throws Exception;
}