package com.story.common.base;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName: BaseDto
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/11/23-10:05 PM
 * @Version:1.0
 */

@Data
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 10000000001L;

    /* 主键 ID */
    private Long id;

    /* 创建时间 */
    private LocalDateTime createTime;

    /* 更新时间 */
    private LocalDateTime updateTime;
}
