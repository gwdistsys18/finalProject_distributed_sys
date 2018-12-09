package com.zz.yuan_user.controller;

import com.zz.yuan_user.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/complete")
@Slf4j
public class SetCompleteController {

    @ResponseBody
    public Result<Boolean> do_login(String username){
        return null;
    }
}
