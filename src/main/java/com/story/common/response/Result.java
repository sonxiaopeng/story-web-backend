package com.story.common.response;

/**
 * ClassName: Result
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/10/23-10:14 PM
 * @Version:1.0
 */
public class Result<T> {

    public int code;

    public String message;

    public T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    static public <T> Result<T> success(){
        return new Result<>(200 , "操作成功" , null);
    }
    static public <T> Result<T> success(T data){
        return new Result<>(200 , "操作成功" , data);
    }

    static public <T> Result<T> success(T data , String message){
        return new Result<>(200 , message , data);
    }

    static public <T> Result<T> fail(){
        return new Result<>(400 , "操作失败" , null);
    }

    static public <T> Result<T> fail(T data){
        return new Result<>(400 , "操作失败" , data);
    }

    static public <T> Result<T> fail(T data , String message){
        return new Result<>(400 , message , data);
    }

    static public <T> Result<T> logout(String message){
        return new Result<>(401 , "登录失效" , null);
    }
}
