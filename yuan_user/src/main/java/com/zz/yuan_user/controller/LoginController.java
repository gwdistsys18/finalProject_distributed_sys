package com.zz.yuan_user.controller;


import com.zz.yuan_user.result.Result;
import com.zz.yuan_user.service.UserService;
import com.zz.yuan_user.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> do_login(@Valid LoginVo loginVo, HttpServletResponse response){
        // log.info(loginVo.toString());\
//        //校验参数
//        String passInput = loginVo.getPassword();
//        String mobile = loginVo.getMobile();
//        if(StringUtils.isEmpty(passInput)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if(StringUtils.isEmpty(mobile)){
//            return Result.error(CodeMsg.MOBILE_EMPTY);
//        }
//        if (!ValidatorUtil.isMobile(mobile)){
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }
        //登录
        userService.login(response,loginVo);
        return Result.success("login success");
    }
}
