package com.story.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.story.common.response.Result;
import com.story.core.dto.UserDto;
import com.story.core.mapstruct.UserMapStruct;
import com.story.core.service.UserService;
import com.story.core.entity.User;
import com.story.core.service.impl.UserServiceImpl;
import com.story.core.vo.UserVo;
import com.story.utils.Transformer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserController
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:29 PM
 * @Version:1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;


    //1.根据id查询用户信息
    @GetMapping("/all")
    public List<User> userList(){
        List<User> list = userService.list();
        return list;
    }

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody UserVo userVo){
        try {
            UserServiceImpl userServiceImpl = (UserServiceImpl) userService;
            Boolean result = userServiceImpl.register(userVo);
            return result ? Result.success(true) : Result.fail(false , "未注册成功");
        }catch (Exception e){
            return Result.fail();
        }
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserVo userVo){
        try {
            UserServiceImpl userServiceImpl = (UserServiceImpl) userService;
            String token = userServiceImpl.login(userVo);
            return Result.success(token);
        }catch (Exception e){
            return Result.fail();
        }
    }


    @PostMapping("/page")
    public Result<Page<UserDto>> page(@RequestBody UserVo userVo){
        try {
            UserServiceImpl userServiceImpl = (UserServiceImpl) userService;
            Page<User> page = userServiceImpl.getPage(userVo);
            Page<UserDto> pageDto = Transformer.toDto(UserMapStruct.INSTANCE, page);
            return Result.success(pageDto);
        }catch (Exception e){
            return Result.fail();
        }
    }
}
