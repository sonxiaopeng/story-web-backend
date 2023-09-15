package com.story.core.vo;

import com.story.common.base.XPage;
import com.story.core.dto.ArticleTypeDto;
import lombok.Data;

import java.sql.Date;

/**
 * ClassName: ArticleTypeVo
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/12/23-10:38 PM
 * @Version:1.0
 */

@Data
public class ArticleTypeVo extends XPage {
    private String typeLabel;
    private String typeProp;
    private String typeDesc;
}
