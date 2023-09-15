package com.story.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.story.common.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

/**
 * ClassName: ArticleType
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-8:15 AM
 * @Version:1.0
 */


@TableName("story_article_type")
@Data
public class ArticleType extends BaseEntity {
    private String typeLabel;
    private String typeProp;
    private String typeDesc;
}
