package com.story.core.vo;

import com.story.common.base.XPage;
import com.story.core.dto.RoleDto;
import lombok.Data;

/**
 * ClassName: RoleVo
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/13/23-8:45 AM
 * @Version:1.0
 */


@Data
public class RoleVo extends XPage {
    private String roleName;
    private String roleProp;
    private String roleDesc;
}
