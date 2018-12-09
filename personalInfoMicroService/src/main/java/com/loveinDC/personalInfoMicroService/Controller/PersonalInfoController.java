package com.loveinDC.personalInfoMicroService.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;
import com.loveinDC.personalInfoMicroService.Service.PersonalInfoService;

import RedisService.RedisSerialization;
import RedisService.UserSession;

@Component
@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController {
	@Autowired
	private PersonalInfoService personalInfoService;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/create")
	public String createPersonalInfo(HttpServletRequest httpServletRequest) throws Exception{
		//get user's cookies
		Cookie[] cookies = httpServletRequest.getCookies();
		String userRedisKey = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loveinDC_token")) {
				userRedisKey = cookie.getValue();
				break;
			}
		}
		//get user session from redis
		String serializedUser = "";
		if(stringRedisTemplate.hasKey(userRedisKey)) {
			serializedUser = stringRedisTemplate.opsForValue().get(userRedisKey);
		} else {
			throw new Exception();
		}
		
		UserSession userSession = RedisSerialization.antiSerialization(serializedUser, UserSession.class);
		
		//get user id
		Integer uid = 0;
		if (userSession == null) {
			throw new Exception();
		} else {
			uid = userSession.getId();
		}
		
		
		PersonalInfo personInfo= new PersonalInfo();
		personInfo.setUid(uid);
		personalInfoService.create(personInfo);
		try {
			return personalInfoService.findByUid(uid).getUid().toString();
		}catch(NullPointerException e) {
			throw new NullPointerException();
		}
	}
	
	@RequestMapping("/delete")
	public String deletePersonalInfo(@RequestParam(value = "uid") Integer uid) {
		int deleteResult = personalInfoService.delete(uid);
		if(deleteResult == 1 ) return "Delete successed";
		else return "Delete failed";
	}
	
	@RequestMapping("/update")
	public PersonalInfo updatePersonalInfo(@RequestParam(value = "uid", required = true) Integer uid,
										   @RequestParam(value = "firstName", required = false) String firstName,
										   @RequestParam(value = "lastName", required = false) String lastName,
										   @RequestParam(value = "nickName", required = false) String nickName,
										   @RequestParam(value = "birthDate", required = false) String birthDate,
										   @RequestParam(value = "gender", required = false) Character gender,
										   @RequestParam(value = "collage", required = false) String collage,
										   @RequestParam(value = "major", required = false) String major) {
		
		PersonalInfo personInfo = personalInfoService.findByUid(uid);
		if (firstName != null) {
			personInfo.setFirstName(firstName);
		}
		if (lastName != null) {
			personInfo.setLastName(lastName);
		}
		if (nickName != null) {
			personInfo.setNickName(nickName);
		}
		if (birthDate != null) {
			personInfo.setBirthDate(birthDate);
		}
		if (gender != null) {
			personInfo.setGender(gender);
		}
		if (collage != null) {
			personInfo.setCollage(collage);
		}
		if (major != null) {
			personInfo.setMajor(major);
		}
		return personalInfoService.update(personInfo);
	}
	
	@RequestMapping("/findByUid")
	public PersonalInfo findPersonalInfoByUid(@RequestParam("uid") Integer uid) {
		return personalInfoService.findByUid(uid);
	}
	
	@RequestMapping("/findAll")
	public List<PersonalInfo> findAllPersonalInfo() {
		return personalInfoService.findAll();
	}
}
