package com.story.core.dto;

import com.story.common.base.BaseDto;
import lombok.Data;

/**
 * ClassName: UserDto
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/14/23-10:45 PM
 * @Version:1.0
 */

@Data
public class UserDto extends BaseDto {

    private String username;

    private Integer gender;
    private Long phone;
    private Integer roleId;
}
