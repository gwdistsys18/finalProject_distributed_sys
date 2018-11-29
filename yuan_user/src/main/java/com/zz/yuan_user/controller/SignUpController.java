package com.zz.yuan_user.controller;

import com.zz.yuan_user.domain.User;
import com.zz.yuan_user.result.CodeMsg;
import com.zz.yuan_user.result.Result;
import com.zz.yuan_user.service.UserService;
import com.zz.yuan_user.vo.LoginVo;
import com.zz.yuan_user.vo.SignUpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/signup")
@Slf4j
public class SignUpController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String tosignup(){
        return "signup";
    }

    @PostMapping("/do_signup")
    @ResponseBody
    public Result<Boolean> signUp(SignUpVo signUpVo){
        boolean res = userService.signup(signUpVo);
        if(res) return Result.success(true);
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
