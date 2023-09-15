package com.story.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName: BaseEntity
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-10:05 PM
 * @Version:1.0
 */

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 10000000000L;

    /* 主键 ID */
    @TableId(type = IdType.AUTO )
    private Long id;

    /* 创建时间 */
    private LocalDateTime createTime;

    /* 更新时间 */
    private LocalDateTime updateTime;

    /* 逻辑删除 （0未删除，1已删除） */
    private Integer deleteFlag = 0;

}
