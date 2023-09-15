package com.story.core.mapstruct;

import com.story.common.base.BaseMapStruct;
import com.story.core.dto.RoleDto;
import com.story.core.dto.UserDto;
import com.story.core.entity.Role;
import com.story.core.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: UserMapStruct
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/14/23-10:55 PM
 * @Version:1.0
 */
@Mapper
public interface UserMapStruct extends BaseMapStruct<UserDto, User> {
    UserMapStruct INSTANCE = Mappers.getMapper(UserMapStruct.class);
}
