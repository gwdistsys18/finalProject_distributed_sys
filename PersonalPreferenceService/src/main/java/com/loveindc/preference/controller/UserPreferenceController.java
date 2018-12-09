package com.loveindc.preference.controller;

import RedisService.RedisSerialization;
import RedisService.UserSession;
import com.loveindc.preference.service.UserPreferenceService;
import com.loveindc.preference.utils.ResultVOUtil;
import com.loveindc.preference.vo.ResultVO;
import com.loveindc.preference.vo.UserPreferenceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/userpreference")
public class UserPreferenceController {
    @Autowired
    private UserPreferenceService userPreferenceService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public boolean checkLoginStatus(HttpServletRequest httpServletRequest) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        String userRedisKey = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loveinDC_token")) {
                userRedisKey = cookie.getValue();
                break;
            }
        }
        // get user session from redis
        String serializedUser = "";
        if (stringRedisTemplate.hasKey(userRedisKey)) {
            serializedUser = stringRedisTemplate.opsForValue().get(userRedisKey);
        } else {
            throw new Exception();
        }
        UserSession userSession = RedisSerialization.deSerialization(serializedUser, UserSession.class);

        // get user id
        Integer uid = 0;
        if (userSession == null) {
            return false;
        } else {
            uid = userSession.getId();
            return true;
        }
    }

    @GetMapping("/preference/{id}")
    public ResultVO<UserPreferenceVO> getUserPreferenceById(@PathVariable("id") int id) {
        UserPreferenceVO ret = userPreferenceService.getById(id);
        return ResultVOUtil.success(ret);
    }

    @PostMapping("/preference/{id}")
    public ResultVO<UserPreferenceVO> createUserPreference(@PathVariable("id") int id) {
        UserPreferenceVO ret = userPreferenceService.create(id);
        return ResultVOUtil.success(ret);
    }

    @PutMapping("/preference")
    public ResultVO<UserPreferenceVO> updateUserPreference(UserPreferenceVO userPreferenceVO) {
        UserPreferenceVO ret = userPreferenceService.update(userPreferenceVO);
        return ResultVOUtil.success(ret);
    }
}
