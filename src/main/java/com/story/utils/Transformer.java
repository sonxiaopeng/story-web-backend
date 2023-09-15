package com.story.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.story.common.base.BaseMapStruct;

import java.util.List;

/**
 * ClassName: Transformer
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/13/23-9:45 PM
 * @Version:1.0
 */
public class Transformer {

    /*
    *  变成一个普通的类
    * */
    public static <D , E> D toDto(BaseMapStruct<D , E> instance , E entity){
        return instance.toDto(entity);
    }


    public static <D , E> E toEntity(BaseMapStruct<D , E> instance , D dto){
        return instance.toEntity(dto);
    }

    public static <D , E> List<D> toDto(BaseMapStruct<D , E> instance , List<E> entities){
        return instance.toDto(entities);
    }

    public static <D , E> List<E> toEntity(BaseMapStruct<D , E> instance , List<D> dtos){
        return instance.toEntity(dtos);
    }

    public static <D , E> Page<D> toDto(BaseMapStruct<D ,  E> instance ,  Page<E> page){
        return instance.toDto(page);
    }
}
