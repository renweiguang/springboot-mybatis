package com.rwg.mapper;

import com.rwg.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbUserMapper
{
    List<TbUser> getUserList();
}
