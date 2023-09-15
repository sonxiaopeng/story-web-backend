package com.story.common.interceptor;

import com.story.utils.RedisTool;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebConfig
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/15/23-9:51 AM
 * @Version:1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    public RedisTool redisTool;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 有一些请求是不用拦截的
        final String[] excludes = { "/user/login" , "/user/register"  };
        registry.addInterceptor(new LoginCheckInterceptor(redisTool)).excludePathPatterns(excludes);
    }
}
