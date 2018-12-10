package com.zz.yuan_user.service;


import com.zz.yuan_user.dao.UserDao;
import com.zz.yuan_user.domain.User;
import com.zz.yuan_user.exception.GlobalException;
import com.zz.yuan_user.redis.UserKey;
import com.zz.yuan_user.redis.RedisService;
import com.zz.yuan_user.result.CodeMsg;
import com.zz.yuan_user.util.MD5Util;
import com.zz.yuan_user.util.UUIDUtil;
import com.zz.yuan_user.vo.LoginVo;
import com.zz.yuan_user.vo.SignUpVo;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;

    public final static String TOKEN_NAME = "loveinDC_token";

    public User getById(Long id){
        return userDao.getById(id);
    }

    //72dfb2863ebdfc4f8515a3fc0cb7e872
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if(loginVo==null) throw new GlobalException(CodeMsg.SERVER_ERROR);
        String username = loginVo.getUsername();
        String pass = loginVo.getPassword();
        //判断是否存在
        User user = userDao.getByUserName(username);
        if(user==null) throw new GlobalException(CodeMsg.USERNAME_NOT_EXIST);
        //验证密码
        String dbpass = user.getPassword();
        String salt = user.getSalt();
        String calPass = MD5Util.formPassToDBPass(pass,salt);
        if (!StringUtils.equals(dbpass,calPass)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        addCookie(response,user);
        return true;
    }

    private void addCookie(HttpServletResponse response, User user){
        //登录成功 生成session
        String token = UUIDUtil.uuid();
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(TOKEN_NAME,token);
        cookie.setMaxAge(UserKey.token.expiireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public User getByToken(String token, HttpServletResponse response) {
        if (StringUtils.isEmpty(token)) return null;
        User user = redisService.get(UserKey.token, token, User.class);
        //延长有效时间
        if (user!=null) addCookie(response,user);
        return user;
    }

    public boolean signup(SignUpVo signUpVo){
        if (signUpVo == null) throw new GlobalException(CodeMsg.SERVER_ERROR);
        String salt = "loveinDC_2_salt" + RandomStringUtils.random(3, 'l','o','v','e','d','c');
        User user = new User();
        user.setSalt(salt);
        user.setUsername(signUpVo.getUsername());
        String pass = MD5Util.formPassToDBPass(signUpVo.getPassword(),salt);
        user.setPassword(pass);
        user.setRegisterDate(new Date());
        User exist = userDao.getByUserName(user.getUsername());
        if(exist!=null) throw new GlobalException(CodeMsg.DUPLICATE_USERNAME);
        int res = userDao.insertUser(user);
        return true;
    }

}

