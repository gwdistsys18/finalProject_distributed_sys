package com.zz.yuan_user.vo;


import com.zz.yuan_user.validator.IsEmail;

import javax.validation.constraints.NotNull;

public class LoginVo {
    @NotNull
    @IsEmail
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
