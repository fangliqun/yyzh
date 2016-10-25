package cqupt.dao;

import cqupt.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid)throws Exception;

    int insert(User record)throws Exception;

    int insertSelective(User record)throws Exception;

    User selectByPrimaryKey(Integer userid)throws Exception;

    int updateByPrimaryKeySelective(User record)throws Exception;

    int updateByPrimaryKey(User record)throws Exception;
}