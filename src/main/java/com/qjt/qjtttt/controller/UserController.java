package com.qjt.qjtttt.controller;

import com.qjt.qjtttt.model.BaseResponse;
import com.qjt.qjtttt.model.User;
import com.qjt.qjtttt.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger _logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/in")
    public String index(Model model){

        model.addAttribute("user1",userService.findById(1).toString());

        model.addAttribute("user2",userService.findById1(1).toString());

        return "index";
    }

    @GetMapping("/")
    @ResponseBody
    public BaseResponse<List<User>> getPageUserList(@PathVariable Integer offset ,@PathVariable Integer limit){
        RowBounds rowBounds=new RowBounds(offset,limit);
        List <User> list=userService.getUserList(rowBounds);
        return new BaseResponse<>(true,"111",list);
    }

    @GetMapping("/{id}")
    public BaseResponse<User> getUser(@PathVariable Integer id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return new BaseResponse<User>(true, "查询成功", userService.findById(id));
    }

//    创建
    @PostMapping("/")
    public BaseResponse<String> postUser(@ModelAttribute User user) {
        userService.insertUser(user);
        return new BaseResponse<>(true, "新增成功", "");
    }


    @PutMapping("/")
    public BaseResponse<Integer> putUser(@ModelAttribute User user) {

        return new BaseResponse<Integer>(true,"11",userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Integer> deleteUser(@PathVariable Integer id) {

        return new BaseResponse<Integer>(true,"11",userService.deleteUser(id));
    }

}
