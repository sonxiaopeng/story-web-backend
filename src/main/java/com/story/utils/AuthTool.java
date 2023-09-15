package com.story.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.story.core.entity.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * ClassName: AuthTool
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/14/23-10:22 PM
 * @Version:1.0
 */
public class AuthTool {

    public static Integer time = (7 * 24 * 60 * 60);

    public static User parseToken(String token){
        List<String> audience = JWT.decode(token).getAudience();
        User user = new User();
        Long id = (long) Integer.parseInt(audience.get(0));
        user.setId(id);
        user.setUsername(audience.get(1));
        return user;
    }

    public static boolean validateToken(String token) {
        try {
            Date expiresAt = JWT.decode(token).getExpiresAt();
            Long now = (long) LocalDateTime.now().getSecond();
            if(now > expiresAt.getTime()){
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getToken(User user) {
        Date start = new Date();//token起始时间
        long currentTime = System.currentTimeMillis() + time;
        Date end = new Date(currentTime);//token结束时间
        String token = "";
        token = JWT.create()
                .withAudience(user.getId().toString() , user.getUsername() , user.getPassword()) //存放接收方的信息
                .withIssuedAt(start)//token开始时间
                .withExpiresAt(end)//token存活截止时间
                .sign(Algorithm.HMAC256(user.getPassword()));//加密
        return token;
    }

}
