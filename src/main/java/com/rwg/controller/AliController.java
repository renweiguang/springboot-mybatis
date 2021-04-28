package com.rwg.controller;

import com.alibaba.fastjson.JSONObject;
import com.rwg.entity.AliGetTokenReqDTO;
import com.rwg.entity.AliGetTokenResDTO;
import com.rwg.entity.AliVerifyTokenResDTO;
import com.rwg.entity.User;
import com.rwg.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
@ResponseBody
@RequestMapping(value = "/ali")
public class AliController
{
    @Autowired
    private UserServiceImpl userService;

    Map<String, String> map = new HashMap<>();

    @PostMapping(value ="/getToken" ,produces = "application/json;charset=UTF-8")
    public AliGetTokenResDTO getToken(@RequestBody AliGetTokenReqDTO aliReqDTO)
    {
        AliGetTokenResDTO aliResDTO;

        User user = User.builder()
                .name(aliReqDTO.getUserName())
                .pwd(aliReqDTO.getPassWord())
                .build();



        boolean login = userService.login(user);

        // 如果登录成功
        if (login)
        {
            aliResDTO = AliGetTokenResDTO.builder()
                    .success(true)
                    .code("200")
                    .message(null)
                    .requestId("EBF5D894-E920-4C6E-BCD3-A803AD5FDD6C")
                    .data(createData())
                    .build();
        }
        else
        {
            aliResDTO = AliGetTokenResDTO.builder()
                    .success(false)
                    .code("500")
                    .message(null)
                    .requestId(null)
                    .data(null)
                    .build();
        }
        return aliResDTO;
    }

    @PostMapping("/verifyToken")
    public AliVerifyTokenResDTO verifyToken(@RequestBody String tokenJsonString)
    {

        JSONObject jsonObject = JSONObject.parseObject(tokenJsonString);
        String token = jsonObject.getString("access_token");

        AliVerifyTokenResDTO aliVerifyTokenResDTO;
        if (map.get(token) != null)
        {
            aliVerifyTokenResDTO = AliVerifyTokenResDTO.builder()
                    .success(true)
                    .code("200")
                    .message(null)
                    .requestId("C1D5D19E-9822-4C5F-922B-1DDCE776CCD0")
                    .build();
            return aliVerifyTokenResDTO;
        }
        else
        {
            aliVerifyTokenResDTO = AliVerifyTokenResDTO.builder()
                    .success(false)
                    .code("500")
                    .message(null)
                    .requestId(null)
                    .build();
        }
        return aliVerifyTokenResDTO;
    }

    private JSONObject createData()
    {
        String uuid = UUID.randomUUID().toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("access_token", uuid);
        jsonObject.put("expires_in", 7199);
        map.put(uuid, "true");
        return jsonObject;
    }
}
