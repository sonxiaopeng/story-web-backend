package com.story.common.interceptor;

import com.story.core.entity.User;
import com.story.utils.AuthTool;
import com.story.utils.RedisTool;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: LoginCheckInterceptor
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/15/23-7:19 PM
 * @Version:1.0
 */

public class LoginCheckInterceptor implements HandlerInterceptor {

    public RedisTool redisTool;

    public LoginCheckInterceptor(RedisTool redisTool){
        this.redisTool = redisTool;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Auth");

        if(token == null || "".equals(token) || token.trim().equals("")){
            response.setStatus(401);
            response.getWriter().print("please login");
            response.getWriter().flush();
            return false;
        }

        boolean isExpired = AuthTool.validateToken(token);

        if(!isExpired){
            response.setStatus(401);
            response.getWriter().print("token is expired");
            response.getWriter().flush();
            return false;
        }

        User user = AuthTool.parseToken(token);

        String key = redisTool.getKey(user.getUsername());

        if(!token.equals(key)){
            response.setStatus(401);
            response.getWriter().print("token is expired");
            response.getWriter().flush();
            return false;
        }

        return true;
    }
}
