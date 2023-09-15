package com.story.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.story.core.dto.ArticleTypeDto;
import com.story.core.dto.RoleDto;
import com.story.core.entity.ArticleType;
import com.story.core.entity.Role;
import com.story.core.mapper.RoleMapper;
import com.story.core.service.RoleService;
import com.story.core.vo.ArticleTypeVo;
import com.story.core.vo.RoleVo;
import org.springframework.stereotype.Service;

/**
 * ClassName: RoleServiceImpl
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:46 PM
 * @Version:1.0
 */

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>  implements RoleService {

    public Page<Role> getPage(RoleVo roleVo){
        Page page = new Page();
        page.setCurrent(roleVo.getCurrent());
        page.setSize(roleVo.getSize());

        QueryWrapper<Role> wrapper = new QueryWrapper<>();

        String roleName = roleVo.getRoleName();
        String roleProp = roleVo.getRoleProp();
        String roleDesc = roleVo.getRoleDesc();

        if(roleName != null){
            wrapper.like("role_name" , roleName);
        }

        if(roleProp != null){
            wrapper.eq("type_prop" , roleProp);
        }

        if(roleDesc != null){
            wrapper.like("type_desc" , roleDesc);
        }

        Page pageEntity = this.page(page, wrapper);
        // 可能需要一个转的过程；
        return pageEntity;
    }
}
