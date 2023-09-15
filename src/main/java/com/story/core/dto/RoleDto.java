package com.story.core.dto;

import com.story.common.base.BaseDto;
import lombok.Builder;
import lombok.Data;

/**
 * ClassName: RoleDto
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-10:27 PM
 * @Version:1.0
 */
@Data
public class RoleDto extends BaseDto {

    private String roleName;
    private String roleProp;
    private String roleDesc;

}
