package com.company.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.company.project.model.User;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用于定向到一个页面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, @RequestParam Map<String, Object> map) throws Exception {
        return "userList";
    }

    /**
     * 将请求需要返回的数据放在body中返回
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "/users")
    @ResponseBody
    public Object users(@RequestParam Map<String, Object> map, HttpServletRequest request) {
        List<User> users = userService.getAllUser();
        String username = (String)map.get("username");
        System.out.println("this is param(username)from client : "+username);
        return users;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody User user, HttpServletRequest request) {
        boolean isSuccess = false;
        if(user !=null){
            System.out.println("get user :username="+user.getUsername()+"  password="+user.getPassword());
        }
        userService.addUser();
        return isSuccess;
    }
}
