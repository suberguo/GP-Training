package com.dds.app.controller;


import com.dds.annotation.Autowired;
import com.dds.annotation.Controller;
import com.dds.annotation.RequestMapping;
import com.dds.annotation.RequestParam;
import com.dds.app.bs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<DdsUser> userList = userService.list();
        for (DdsUser user :userList) {
            response.getWriter().write(user.toString());
        }

    }

    @RequestMapping("/?userId={0}")
    public void get(@RequestParam("userId") String userId){

    }


}
