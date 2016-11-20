package cqupt.dao;

import java.util.List;

import cqupt.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String username)throws Exception;

    int insert(User user)throws Exception;
    
    List<User> selectAllUser()throws Exception;
    
    User login(User user)throws Exception;

    int insertSelective(User record)throws Exception;

    User selectByPrimaryKey(Integer userid)throws Exception;

    int updateByPrimaryKeySelective(User record)throws Exception;

    int updateByPrimaryKey(User record)throws Exception;
}