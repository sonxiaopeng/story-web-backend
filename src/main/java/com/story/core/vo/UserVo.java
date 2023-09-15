package com.story.core.vo;

import com.story.common.base.XPage;
import lombok.Data;

/**
 * ClassName: UserVo
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/13/23-10:31 PM
 * @Version:1.0
 */

@Data
public class UserVo extends XPage {

    private String username;
    private String password;
    // 搜索条件
    private Integer gender;
    private Long phone;
    private Integer roleId;
}
