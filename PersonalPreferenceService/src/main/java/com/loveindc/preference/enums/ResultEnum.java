package com.loveindc.preference.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "success"),
    USERNAME_NOT_EXIST(40100, "用户名不存在"),
    PASSWORD_ERROR(40101, "用户密码错误"),
    DUPLICATE_ERROR(500210, "用户名已存在"),
    SERVER_ERROR(501, "服务端异常");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}