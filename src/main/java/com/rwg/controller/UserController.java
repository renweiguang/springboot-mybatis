package com.rwg.controller;

import com.alibaba.fastjson.JSONObject;
import com.rwg.entity.AliGetTokenReqDTO;
import com.rwg.entity.AliGetTokenResDTO;
import com.rwg.entity.User;
import com.rwg.service.UserService;
import com.rwg.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rwg
 * @date 2020/7/5 -16:54
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping(value = "/user")
// @Api和ApiOpertion都是来自于swagger包依赖，他们的作用是生成接口文档。
@Api(value = "UserController", description = "用户界面")

public class UserController
{

    // 读取配置文件中属性的值
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private UserServiceImpl userService;

    /**
     * 一个接口，两个实现类实现一个接口，那么只需要在两个实现类上面，定义@Service(“person”/“user”)
     * 然后这边new 接口。  用@Qualifier表示用哪个。。。
     */
    @Autowired
    @Qualifier("person")
    private UserService service;

    @GetMapping("/serviceKuohaotest")
    public String serviceKuohaotest()
    {
        return service.testServiceKuoHao();
    }

    @PostMapping("listDemo")
    public List<User> listDemo(@RequestBody List<Integer> list)
    {
        List<User> userList = userService.queryListDemo(list);
        return userList;
    }

    @ApiOperation(value = "登录", notes = "登录")
    @GetMapping("login")
    public boolean login(HttpSession session)
    {
        User user = User.builder()
                .name("asd")
                .pwd("R1101056071")
                .build();
        boolean login = userService.login(user);
        session.setAttribute("USER", login);
        log.info("登录啦");
        return login;
    }

    // localhost:8080/get_method/mode_1/tony/89
    @PostMapping(path = "mode_1/{name}/{age}")
    public Map getUrlPathParam(@PathVariable("name") String name, @PathVariable String age, @RequestBody String ag)
    {
        System.out.println(ag);
        return new HashMap()
        {
            {
                put("name", name);
                put("age", age);
            }
        };
    }
    // localhost:8080/get_method/mode_2?name=tony&age=89
    @GetMapping("mode_2")
    public Map getQueryParam(@RequestParam(name = "name") String name, @RequestParam(defaultValue = "100") String age)
    {
        return new HashMap()
        {
            {
                put("name", name);
                put("age", age);
                log.info("名字为:{},年龄为:{}", name, age);
            }
        };
    }

    @GetMapping("mode_3")
    public Map testHashMapResult(@RequestParam(name = "name") String name,
            @RequestParam(defaultValue = "100") String age)
    {
        HashMap<Integer, String> hashMap = new HashMap();
        hashMap.put(1, name);
        hashMap.put(2, age);
        hashMap.put(3, age);
        System.out.println(serverPort);
        System.out.println(hashMap);
        return hashMap;
    }

    @PostMapping("/testArray")
    public List<User> testArray(@RequestBody int[] array)
    {
        return userService.testArray(array);
    }

    @GetMapping("/testMap")
    public List<User> testMap()
    {
        int[] ids = { 1, 2, 3, 6 };
        log.info("ids的值为{}", ids);
        Map<String, Object> map = new HashMap<>();
        map.put("id", ids);
        List<User> user = userService.testMap(map);
        return user;
    }

    @GetMapping("/queryUserList")
    public List<User> queryUserList()
    {
        List<User> userList = userService.queryUserList();
        return userList;
    }

    @PostMapping("/addUserList")
    public String addUserList(@RequestBody List<User> userList)
    {
        System.out.println(userList);
        System.out.println(JSONObject.toJSONString(userList));
        userList.stream().forEach(r -> userService.addUser(r));
        return "addUserList";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        userService.addUser(user);
        System.out.println("addUser方法執行完了");
        return "addUser";
    }

    @PostMapping("/addUser1")
    public String addUser(@RequestBody String jsonString)
    {

        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        User user1 = User.builder().name(jsonObject.getString("name")).pwd(jsonObject.getString("pwd")).build();
        userService.addUser(user1);
        System.out.println("addUser方法執行完了");
        return "addUser";
    }

    @PostMapping("/addJsonStringUser")
    public String addJsonStringUser(@RequestBody String jsonStringUser)
    {
        User user = new User();
        JSONObject jsonObject = JSONObject.parseObject(jsonStringUser);
        user.setName(jsonObject.getString("name"));
        user.setPwd(jsonObject.getString("pwd"));
        userService.addUser(user);
        System.out.println("addUser方法執行完了");
        return "addUser";
    }

    @PostMapping("/addJsonListStringUser")
    public String addJsonListStringUser(@RequestBody String jsonStringUser)
    {
        List<User> userList = JSONObject.parseArray(jsonStringUser, User.class);
        userList.stream().forEach(r -> userService.addUser(r));
        System.out.println("addUser方法執行完了");
        return "addUser";
    }

    @PostMapping("/selectRecByPwd")
    public List<User> selectRecByPwd(@RequestBody String pwd)
    {
        JSONObject jsonObject = JSONObject.parseObject(pwd);
        String pwd1 = jsonObject.getString("pwd");
        List<User> userList = userService.selectRecByPwd(pwd1);
        return userList;
    }

    @PostMapping("/testJsonField")
    public String testJsonField(@RequestBody String cmdOpt)
    {
        // JSONObject.parseObject不在乎传参大小写，字母对上就行
        User user = JSONObject.parseObject(cmdOpt, User.class);
        System.out.println(user);
        return "ok";
    }

    @GetMapping("/testLike")
    public List<User> testLike()
    {
        return userService.testLike();
    }

    @GetMapping("/updateUser")
    public String updateUser()
    {
        userService.updateUser(new User(888, "xyj222", "777"));
        return "updateUser";
    }

    @GetMapping(path = "deleteUser")
    public String deleteUser(@RequestParam("id") int id)
    {
        userService.deleteUser(id);
        return "deleteUser";
    }

    // 如果直接获取插入的返回值，其实返回的是影响的行数
    // 他会将返回的之间塞入传进去的实体里，我们需要解析实体类。

    @GetMapping("/testInsertReturnPrimaryKey")
    public int insertReturnPrimaryKey()
    {
        User user = new User();
        user.setName("xiaoxiaobaobao");
        user.setPwd("11");
        int column = userService.insertReturnPrimaryKey(user);
        log.info("影响的行数为:{}", column);
        log.info("返回插入的主键值为:{}", user.getId());
        return user.getId();
    }

    @PostMapping(value = "/getToken", produces = "application/json;charset=UTF-8")
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
                    .data(null)
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
}