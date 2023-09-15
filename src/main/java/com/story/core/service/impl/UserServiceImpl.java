package com.story.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.story.core.dto.UserDto;
import com.story.core.entity.Role;
import com.story.core.service.UserService;
import com.story.core.entity.User;
import com.story.core.mapper.UserMapper;
import com.story.core.vo.UserVo;
import com.story.utils.AuthTool;
import com.story.utils.Encoder;
import com.story.utils.RedisTool;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ClassName: UserServiceImpl
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:27 PM
 * @Version:1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements UserService {


    @Resource
    public RedisTool redisTool;

    //一个plus版本的serviceImpl
    public Boolean register(UserVo userVo){
        // 注册用户接口
        User user = new User();

        User canDo = this.getByUserName(userVo.getUsername());

        if(canDo != null){
            return false;
        }

        user.setUsername(userVo.getUsername());

        String password = userVo.getPassword();

        String encode = Encoder.encode(password);

        user.setPassword(encode);

        user.setCreateTime(LocalDateTime.now());

        boolean save = this.save(user);

        return save;
    }

    public User getByUserName(String username){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username" , username);
        User one = this.getOne(queryWrapper);
        if(one != null){ // 说明不能注册
            return one;
        }

        return null;
    }


    public String login(UserVo userVo){
        // 查看存不存在
        String username = userVo.getUsername();
        String password = userVo.getPassword();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username"  , username);
        queryWrapper.eq("password" , Encoder.encode(password));

        User one = this.getOne(queryWrapper);

        if(one != null){
            // 说明查到了
            String token = AuthTool.getToken(one);
            redisTool.setKey(username , token);
            return token;
        }

        return null;
    }


    public Page<User> getPage(UserVo userVo){
        Page page = new Page();
        page.setCurrent(userVo.getCurrent());
        page.setSize(userVo.getSize());

        QueryWrapper queryWrapper = new QueryWrapper();

        Integer roleId = userVo.getRoleId();

        Integer gender = userVo.getGender();

        Long phone = userVo.getPhone();

        if(roleId != null){
            queryWrapper.eq( "role_id", roleId);
        }

        if(gender != null){
            queryWrapper.eq("gender" , gender);
        }

        if(phone != null){
            queryWrapper.eq("phone" , phone);
        }

        Page page1 = this.page(page, queryWrapper);

        return page1;
    }
}
