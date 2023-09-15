package com.story.common.base;

import lombok.Data;

import java.util.List;

/**
 * ClassName: XPage
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/12/23-10:38 PM
 * @Version:1.0
 */

@Data
public class XPage{

    public Integer current;
    public Integer size;
    public Integer total;

}
