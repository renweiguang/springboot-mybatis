package com.rwg.service;

import com.rwg.entity.User;
import com.rwg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public List<User> getUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<User> queryListDemo(List<Integer> list) {
        return userMapper.queryListDemo(list);
    }

    @Override
    public List<User> testArray(int[] IdList) {
        return userMapper.testArray(IdList);
    }

    @Override
    public List<User> testMap(Map<String, Object> map) {
        return userMapper.testMap(map);
    }

    @Override
    public List<User> testLike() {
        return userMapper.testLike();
    }

    @Override
    public int insertReturnPrimaryKey(User user) {
        return userMapper.insertReturnPrimaryKey(user);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public boolean login(User user) {
        if (userMapper.selectByUserAndPassword(user) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String testServiceKuoHao() {
        return "user";
    }

    @Override
    public List<User> selectRecByPwd(String pwd) {
        return userMapper.selectRecByPwd(pwd);
    }
}
