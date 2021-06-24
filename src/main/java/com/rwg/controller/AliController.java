package com.rwg.controller;

import com.alibaba.fastjson.JSONObject;
import com.rwg.entity.AliGetTokenReqDTO;
import com.rwg.entity.AliGetTokenResDTO;
import com.rwg.entity.AliVerifyTokenResDTO;
import com.rwg.entity.User;
import com.rwg.entity.XzResDTO;
import com.rwg.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(value = "/getToken", produces = "application/json;charset=UTF-8")
    public AliGetTokenResDTO getToken(@RequestBody AliGetTokenReqDTO aliReqDTO)
    {
        log.info("调用验证中心获取token接口");
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

        String jsonString = JSONObject.toJSONString(aliResDTO);

        log.info("验证中心获取token接口返回值为： " + jsonString);
        return aliResDTO;
    }

    @PostMapping("/verifyToken")
    public AliVerifyTokenResDTO verifyToken(@RequestBody String tokenJsonString)
    {
        log.info("调用验证中心验证token接口");

        JSONObject jsonObject = JSONObject.parseObject(tokenJsonString);
        String token = jsonObject.getString("access_token");

        AliVerifyTokenResDTO aliVerifyTokenResDTO;
//        if (map.get(token) != null)
//        {
            aliVerifyTokenResDTO = AliVerifyTokenResDTO.builder()
                    .success(true)
                    .code("200")
                    .message(null)
                    .requestId("C1D5D19E-9822-4C5F-922B-1DDCE776CCD0")
                    .build();
//        }
//        else
//        {
//            aliVerifyTokenResDTO = AliVerifyTokenResDTO.builder()
//                    .success(false)
//                    .code("500")
//                    .message(null)
//                    .requestId(null)
//                    .build();
//        }
        String jsonString = JSONObject.toJSONString(aliVerifyTokenResDTO);

        log.info("验证中心验证token接口返回值为： " + jsonString);
        return aliVerifyTokenResDTO;
    }
    @PostMapping("/loginByToken")
    public String loginByToken(@RequestBody String tokenJsonString)
    {
        System.out.println(tokenJsonString);
        XzResDTO xzResDTO = XzResDTO.builder()
                .SFZH("120104198807012412")
                .YHMC("renweiguang")
                .SEX("1")
                .JH("105768")
                .JZDM("01")
                .LXDH("022-00000001")
                .SJHM("18220617581")
                .GAJGJGDM("120106000000")
                .GAJGJGMC("XX省XX市XX分局")
                .ZXBS("0")
                .GXSJ("2020-07-01 22:22:22").build();

        log.info(JSONObject.toJSONString(xzResDTO));

        return JSONObject.toJSONString(xzResDTO);
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

    @GetMapping("getXzToken")
    public void getToken(@RequestParam(name = "b_token") String b_token)
    {
       log.info(b_token);
    }


    @GetMapping("getUserInfoByToken")
    public String getUserInfoByToken(@RequestParam(name = "access_token") String token)
    {
        System.out.println(token);
        return "{\n"
                + "    \"success\": true,\n"
                + "    \"code\": \"200\",\n"
                + "    \"message\": null,\n"
                + "    \"requestId\": \"3D42DDD7-B2C6-4D10-94F7-7FAEAD8D0E33\",\n"
                + "    \"data\": {\n"
                + "        \"externalId\": \"4544224858182154114\",\n"
                + "        \"username\": \"qdga-jzzzw\",\n"
                + "        \"displayName\": \"经侦指掌纹自动识别系统\",\n"
                + "        \"phoneNumber\": null,\n"
                + "        \"phoneRegion\": \"86\",\n"
                + "        \"email\": \"qdgajzzzw@163.com\",\n"
                + "        \"locked\": false,\n"
                + "        \"enabled\": true,\n"
                + "        \"description\": \"\",\n"
                + "        \"extendFields\": {},\n"
                + "        \"belongs\": [\n"
                + "            \"6096335190559271858\"\n"
                + "        ]\n"
                + "    }\n"
                + "}";
    }
}
