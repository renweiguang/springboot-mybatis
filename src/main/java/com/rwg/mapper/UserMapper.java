package com.rwg.mapper;

import com.rwg.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper
{

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> queryListDemo(List<Integer> userlist);

    List<User> testArray(int[] IdList);

    List<User> testMap(Map<String, Object> map);

    List<User> testLike();

    int insertReturnPrimaryKey(User user);

    User selectByUserAndPassword(User user);

    List<User> selectRecByPwd(@Param("pwd") String pwd);
}