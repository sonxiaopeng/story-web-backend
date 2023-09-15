package com.story.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: Encoder
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/14/23-12:53 PM
 * @Version:1.0
 */
public class Encoder {

    public static String encode(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = password.getBytes();
            byte[] digest = md.digest(passwordBytes);

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x" , b & 0xff));
            }

            return sb.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("MD5 error");
        }
    }


    public static boolean verify(String inputPassword , String hashedPassword){
        String hashEdInput = encode(inputPassword);
        return hashEdInput.equals(hashedPassword);
    }

}
