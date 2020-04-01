package com.qjt.qjtttt.restcontroller;

import com.qjt.qjtttt.model.BaseResponse;
import com.qjt.qjtttt.model.User;
import com.qjt.qjtttt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "apivalue", tags = "apitags", description = "aipdes")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "200"),
        @ApiResponse(code = 404, message = "404")
})
@RestController
@RequestMapping("/users")
public class UserRestController {

    private static final Logger _logger = LoggerFactory.getLogger(UserRestController.class);
    @Resource
    private UserService userService;

    @ApiOperation(value = "apiop value", notes = "apiop notes", produces = "application/json")
    @GetMapping("/")
    public BaseResponse<List<User>> getPageUserList(@PathVariable Integer offset, @PathVariable Integer limit) {
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<User> list = userService.getUserList(rowBounds);
        return new BaseResponse<>(true, "111", list);
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

        return new BaseResponse<Integer>(true, "11", userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Integer> deleteUser(@PathVariable Integer id) {

        return new BaseResponse<Integer>(true, "11", userService.deleteUser(id));
    }


}
