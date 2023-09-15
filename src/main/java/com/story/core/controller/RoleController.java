package com.story.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.story.common.response.Result;
import com.story.core.dto.RoleDto;
import com.story.core.entity.Role;
import com.story.core.mapstruct.RoleMapStruct;
import com.story.core.service.RoleService;
import com.story.core.service.impl.RoleServiceImpl;
import com.story.core.vo.RoleVo;
import com.story.utils.Transformer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: RoleController
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-5:42 PM
 * @Version:1.0
 */


@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController { // 角色


    @Resource
    public RoleService roleService;


    // 1.
    @GetMapping("/list")
    public Result<List<RoleDto>> list(){

        try {
            List<Role> list = roleService.list();

            List<RoleDto> dtoList = Transformer.toDto(RoleMapStruct.INSTANCE, list);
            return Result.success(dtoList);
        }catch (Exception e){
            return Result.fail();
        }

    }

    @PostMapping("/page")
    public Result<Page<RoleDto>> page( RoleVo roleVo , RoleDto roleDto){
        try {
            RoleServiceImpl roleServiceImpl = (RoleServiceImpl) roleService;
            Page<Role> page = roleServiceImpl.getPage(roleVo);
            Page<RoleDto> pageDto = Transformer.toDto(RoleMapStruct.INSTANCE, page);
            return Result.success(pageDto);
        }catch (Exception e){
            return Result.fail();
        }
    }

    // 2. 添加一个角色
    @PostMapping("/addOrUpdate")
    public Result<Boolean> add(@RequestBody Role role){

        try {
            boolean save = roleService.saveOrUpdate(role);
            return Result.success(save);
        }catch (Exception e){
            return Result.fail(false);
        }
    }

    @DeleteMapping("/delete")
    public Result<Boolean> remove(@RequestParam Integer id){
        try {
            boolean b = roleService.removeById(id);
            return Result.success(b);
        }catch (Exception e){
            return Result.fail(false);
        }
    }

    @GetMapping("/getById")
    public Result<RoleDto> getById(@RequestParam Integer id){
        try {
            Role result = roleService.getById(id);
            RoleDto dto = Transformer.toDto(RoleMapStruct.INSTANCE, result);
            return Result.success(dto);
        }catch (Exception e){
            return Result.fail();
        }
    }

}
