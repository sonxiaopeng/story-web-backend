package com.story.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.story.common.response.Result;
import com.story.core.dto.ArticleTypeDto;
import com.story.core.entity.ArticleType;
import com.story.core.mapstruct.ArticleTypeMapStruct;
import com.story.core.service.ArticleTypeService;
import com.story.core.service.impl.ArticleTypeServiceImpl;
import com.story.core.vo.ArticleTypeVo;
import com.story.utils.Transformer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: ArticleTypeController
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-8:17 AM
 * @Version:1.0
 */

@RestController
@RequestMapping("/articleType")
@CrossOrigin
public class ArticleTypeController {

    @Resource
    public ArticleTypeService articleTypeService;


    @GetMapping("/list")
    public Result<List<ArticleTypeDto>> list(){
        try {
            List<ArticleType> list = articleTypeService.list();
            List<ArticleTypeDto> dtoList = Transformer.toDto(ArticleTypeMapStruct.INSTANCE, list);
            return Result.success(dtoList);
        }catch (Exception e){
            return Result.fail();
        }
    }

    @PostMapping("/page")
    public Result<Page<ArticleTypeDto>> page(@RequestBody ArticleTypeVo articleTypeVo){
        try {
            ArticleTypeServiceImpl impl = (ArticleTypeServiceImpl) articleTypeService;
            Page<ArticleType> page = impl.getPage(articleTypeVo);
            Page<ArticleTypeDto> pageDto = Transformer.toDto(ArticleTypeMapStruct.INSTANCE , page);
            return Result.success(pageDto);
        }catch (Exception e){
            return Result.fail();
        }
    }



    @PostMapping("/addOrUpdate")
    public Result<Boolean> addOrUpdate(@RequestBody ArticleType articleType){
        try {

            ArticleTypeServiceImpl articleTypeService1 = (ArticleTypeServiceImpl) articleTypeService;

            boolean b = articleTypeService1.addOrUpdate(articleType);

            return Result.success(b);

        }catch (Exception e){

            return Result.fail(false);
        }
    }


    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestParam Integer id){
        try {
            boolean b = articleTypeService.removeById(id);
            return Result.success(b);
        }catch (Exception e){
            return Result.fail(false);
        }
    }

    @DeleteMapping("/deleteByList")
    public Result<Boolean> deleteByList(@RequestBody Integer[] ids){
        try {
            boolean b = articleTypeService.removeBatchByIds(Arrays.asList(ids));
            return Result.success(b);
        }catch (Exception e){
            return Result.fail(false);
        }
    }


    @GetMapping("/getById")
    public Result<ArticleTypeDto> getById(@RequestParam Integer id){
        try {
            ArticleType result = articleTypeService.getById(id);

            ArticleTypeDto dto = Transformer.toDto(ArticleTypeMapStruct.INSTANCE , result);

            return Result.success(dto);
        }catch (Exception e){
            return Result.fail();
        }
    }

}
