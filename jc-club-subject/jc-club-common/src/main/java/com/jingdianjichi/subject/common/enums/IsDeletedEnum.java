package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

@Getter
public enum IsDeletedEnum {

    DELETED(1,"已经删除"),
    UN_DELETED(0,"未删除");
    private int code;
    private String desc;
    IsDeletedEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedEnum getByCode(int codeVal){
        for (IsDeletedEnum resultCodeEnum : IsDeletedEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
