package com.rwg.service;

import com.rwg.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService
{
    List<User> queryUserList();

    List<User> getUserList();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> queryListDemo(List<Integer> list);

    List<User> testArray(int[] IdList);

    List<User> testMap(Map<String, Object> map);

    List<User> testLike();

    int insertReturnPrimaryKey(User user);

    boolean login(User user);

    String testServiceKuoHao();

    List<User> selectRecByPwd(String pwd);

    int insertUser(User user);


    User selectByCondition();
}
