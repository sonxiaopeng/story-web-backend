package com.story.common.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * ClassName: BaseMapStruct
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/13/23-12:46 PM
 * @Version:1.0
 */
public interface BaseMapStruct<D , E> {

    E toEntity(D dto);


    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Page<D> toDto(Page<E> page);

}
