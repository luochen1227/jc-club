package com.jingdianjichi.subject.common.entity;

import com.jingdianjichi.subject.common.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Boolean success;
    private Integer code;
    private String message;
    private T data;




    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        return result;
    }

    public static <T> Result ok(T data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }
    public static <T> Result<T> ok(T data,String message){
        return new Result<>(true,200,message,data);
    }

    public static Result fail(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        return result;
    }

    public static <T> Result fail(T data){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        result.setData(data);
        return result;
    }
    public static <T> Result<T> fail(T data,String message)
    {
        return new Result<>(false,500,message,data);
    }
}
