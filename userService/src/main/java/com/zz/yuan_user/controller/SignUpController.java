package com.zz.yuan_user.controller;

import com.zz.yuan_user.result.CodeMsg;
import com.zz.yuan_user.result.Result;
import com.zz.yuan_user.service.UserService;
import com.zz.yuan_user.vo.SignUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/signup")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class SignUpController {
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseBody
    public Result<String> signUp(SignUpVo signUpVo){
        boolean res = userService.signup(signUpVo);
        if(res) return Result.success("signup success");
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
