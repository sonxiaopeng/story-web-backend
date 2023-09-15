package com.story.core.dto;

import com.story.common.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * ClassName: ArticleTypeDto
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-10:24 PM
 * @Version:1.0
 */

@Data
public class ArticleTypeDto extends BaseDto {

    private String typeLabel;
    private String typeProp;
    private String typeDesc;

}
