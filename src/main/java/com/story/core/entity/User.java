package com.story.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.story.common.base.BaseEntity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName: User
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:19 PM
 * @Version:1.0
 */

@Data
@TableName("story_user")
public class User extends BaseEntity {
    private String username;
    private String password;
    private Integer gender;
    private Long phone;
    private Integer roleId;
}
