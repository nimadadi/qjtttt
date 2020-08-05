package com.qjt.qjtttt.restcontroller;

import com.qjt.qjtttt.model.BaseResponse;
import com.qjt.qjtttt.model.User;
import com.qjt.qjtttt.service.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;

    @ApiOperation(value = "apiop value", notes = "apiop notes", produces = "application/json")
    @GetMapping("/")
    public BaseResponse getPageUserList(@PathVariable Integer offset, @PathVariable Integer limit) {
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<User> list = userServiceImpl.getUserList(rowBounds);
        return BaseResponse.success(list);
    }

    @GetMapping("/{id}")
    public BaseResponse getUser(@PathVariable Integer id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return BaseResponse.success(userServiceImpl.findById(id));
    }

    //    创建
    @PostMapping("/")
    public BaseResponse postUser(@ModelAttribute User user) {
        return BaseResponse.success(userServiceImpl.insertUser(user));
    }

    @PutMapping("/")
    public BaseResponse putUser(@ModelAttribute User user) {
        return BaseResponse.success(userServiceImpl.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteUser(@PathVariable Integer id) {
        return BaseResponse.success(userServiceImpl.deleteUser(id));
    }


}
