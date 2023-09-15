package com.story.core.mapstruct;

import com.story.common.base.BaseMapStruct;
import com.story.core.dto.ArticleTypeDto;
import com.story.core.entity.ArticleType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: ArticleTypeMapStruct
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/13/23-12:49 PM
 * @Version:1.0
 */

@Mapper
public interface ArticleTypeMapStruct extends BaseMapStruct<ArticleTypeDto , ArticleType> {
    ArticleTypeMapStruct INSTANCE = Mappers.getMapper(ArticleTypeMapStruct.class);
}
