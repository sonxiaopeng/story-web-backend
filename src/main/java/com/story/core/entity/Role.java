package com.story.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.story.common.base.BaseEntity;
import lombok.Data;

import java.security.PrivilegedAction;

/**
 * ClassName: Role
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:43 PM
 * @Version:1.0
 */

@Data
@TableName("story_role")
public class Role extends BaseEntity {

    private String roleName;
    private String roleProp;
    private String roleDesc;
}
