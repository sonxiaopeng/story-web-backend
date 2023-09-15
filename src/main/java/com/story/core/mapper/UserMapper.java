package com.story.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.story.core.entity.User;

/**
 * ClassName: UserMapper
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:18 PM
 * @Version:1.0
 */
public interface UserMapper extends BaseMapper<User> {
    // 这就是一个具备增删改查能力的mapper
}
