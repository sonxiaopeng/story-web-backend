package com.story.core.mapstruct;

import com.story.common.base.BaseMapStruct;
import com.story.core.dto.RoleDto;
import com.story.core.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: RoleMapStruct
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/13/23-10:20 PM
 * @Version:1.0
 */

@Mapper
public interface RoleMapStruct extends BaseMapStruct<RoleDto, Role> {
    RoleMapStruct INSTANCE = Mappers.getMapper(RoleMapStruct.class);
}
