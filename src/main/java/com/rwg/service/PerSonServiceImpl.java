package com.rwg.service;

import com.rwg.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("person")
public class PerSonServiceImpl implements UserService
{
    @Override public List<User> queryUserList()
    {
        return null;
    }
    @Override public List<User> getUserList()
    {
        return null;
    }
    @Override public int addUser(User user)
    {
        return 0;
    }
    @Override public int updateUser(User user)
    {
        return 0;
    }
    @Override public int deleteUser(int id)
    {
        return 0;
    }
    @Override public List<User> queryListDemo(List<Integer> list)
    {
        return null;
    }
    @Override public List<User> testArray(int[] IdList)
    {
        return null;
    }
    @Override public List<User> testMap(Map<String, Object> map)
    {
        return null;
    }
    @Override public List<User> testLike()
    {
        return null;
    }
    @Override public int insertReturnPrimaryKey(User user)
    {
        return 0;
    }
    @Override public boolean login(User user)
    {
        return false;
    }
    @Override public String testServiceKuoHao()
    {
        return "person";
    }
    @Override public List<User> selectRecByPwd(String pwd)
    {
        return null;
    }
    @Override public int insertUser(User user)
    {
        return 0;
    }

    @Override
    public User selectByCondition() {
        return null;
    }

}
