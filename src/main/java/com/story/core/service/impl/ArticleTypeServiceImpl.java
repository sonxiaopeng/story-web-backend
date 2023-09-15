package com.story.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.story.core.dto.ArticleTypeDto;
import com.story.core.service.ArticleTypeService;
import com.story.core.entity.ArticleType;
import com.story.core.mapper.ArticleTypeMapper;
import com.story.core.vo.ArticleTypeVo;
import com.story.utils.Transformer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: ArticleTypeServiceImpl
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-8:19 AM
 * @Version:1.0
 */
@Service
public class ArticleTypeServiceImpl extends ServiceImpl<ArticleTypeMapper , ArticleType> implements ArticleTypeService {

    public Page<ArticleType> getPage(ArticleTypeVo articleTypeVo){
        Page page = new Page();
        page.setCurrent(articleTypeVo.getCurrent());
        page.setSize(articleTypeVo.getSize());

        QueryWrapper<ArticleType> wrapper = new QueryWrapper<>();

        String label = articleTypeVo.getTypeLabel();
        String prop = articleTypeVo.getTypeProp();
        String desc = articleTypeVo.getTypeDesc();

        if(label != null){
            wrapper.like("type_label" , label);
        }

        if(prop != null){
            wrapper.eq("type_prop" , prop);
        }

        if(desc != null){
            wrapper.like("type_desc" , desc);
        }

        Page<ArticleType> pageEntity = this.page(page, wrapper);

        return pageEntity;
    }


    public Boolean addOrUpdate(ArticleType articleType){

        Long id = articleType.getId();

        if(id == null){
            // 说明是新增
            articleType.setCreateTime(LocalDateTime.now());
        }else{
            articleType.setUpdateTime(LocalDateTime.now());
        }

        return this.saveOrUpdate(articleType);
    }

}
