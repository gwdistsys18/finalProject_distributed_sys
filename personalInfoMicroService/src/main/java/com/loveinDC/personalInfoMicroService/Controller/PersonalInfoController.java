package com.loveinDC.personalInfoMicroService.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loveinDC.personalInfoMicroService.Converter.PersonalInfoDAOtoVO;
import com.loveinDC.personalInfoMicroService.Converter.PersonalInfoVOtoDAO;
import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;
import com.loveinDC.personalInfoMicroService.Service.PersonalInfoService;
import com.loveinDC.personalInfoMicroService.Utils.ResultVOUtil;
import com.loveinDC.personalInfoMicroService.VO.PersonalInfoVO;
import com.loveinDC.personalInfoMicroService.VO.ResultVO;
import com.loveinDC.personalInfoService.Enumer.ResultEnum;

import RedisService.RedisSerialization;
import RedisService.UserSession;

@RestController
@RequestMapping("/api/personalInfo")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class PersonalInfoController {
	@Autowired
	private PersonalInfoService personalInfoService;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/")
	public String index() {
		return "Hello from personalInfo micro service of Love in DC";
	}
	
	@RequestMapping("/create")
	public ResultVO<PersonalInfoVO> createPersonalInfo(HttpServletRequest httpServletRequest) throws Exception{
		Integer id = getId(httpServletRequest);
		//if user session not exist which means the user did not log in
		if (id == -1) {
			//return an error message
			return ResultVOUtil.error(ResultEnum.USER_NOT_LOGIN);
		}
		PersonalInfo personInfo= new PersonalInfo();
		personInfo.setId(id);
		personalInfoService.create(personInfo);
		try {
			//Try to find the new created user by its id.
			personInfo = personalInfoService.findById(id);
			PersonalInfoVO personalInfoVO = PersonalInfoDAOtoVO.personalInfoDAOtoVO(personInfo);
			return ResultVOUtil.success(personalInfoVO);
		}catch(NullPointerException e) {
			//some error happens when create a user and save it to database
			return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
			//throw new NullPointerException();
		}
	}
	
	@RequestMapping("/delete")
	public ResultVO<PersonalInfoVO> deletePersonalInfo(HttpServletRequest httpServletRequest) throws Exception {
		Integer id = getId(httpServletRequest);
		//if user session not exist which means the user did not log in
		if (id == -1) {
			//return an error message
			return ResultVOUtil.error(ResultEnum.USER_NOT_LOGIN);
		}
		int deleteResult = personalInfoService.delete(id);
		if(deleteResult == 1 ) return ResultVOUtil.success();
		else return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
	}
	
	@PostMapping("/update")
	public ResultVO<PersonalInfoVO> updatePersonalInfo(PersonalInfoVO personalInfoVO, HttpServletRequest httpServletRequest) throws Exception {	
		Integer id = getId(httpServletRequest);
		//if user session not exist which means the user did not log in
		if (id == -1) {
			//return an error message
			return ResultVOUtil.error(ResultEnum.USER_NOT_LOGIN);
		}
		PersonalInfo personInfo = personalInfoService.findById(id);
		PersonalInfoVOtoDAO.personalInfoDAOtoVO(personInfo, personalInfoVO);
//		String firstName = httpServletRequest.getParameter("firstName");
//		if (firstName != null) {
//			personInfo.setFirstName(firstName);
//		}
//		String lastName = httpServletRequest.getParameter("lastName");
//		if (lastName != null) {
//			personInfo.setLastName(lastName);
//		}
//		String nickName = httpServletRequest.getParameter("nickName");
//		if (nickName != null) {
//			personInfo.setNickName(nickName);
//		}
//		String birthDate = httpServletRequest.getParameter("birthDate");
//		if (birthDate != null && birthDate.length() == 10) {
//			personInfo.setBirthDate(birthDate);
//		}
//		String gender = httpServletRequest.getParameter("gender");
//		if (gender != null) {
//			personInfo.setGender(gender.charAt(0));
//		}
//		String college = httpServletRequest.getParameter("college");
//		if (college != null) {
//			personInfo.setCollege(college);
//		}
//		String major = httpServletRequest.getParameter("major");
//		if (major != null) {
//			personInfo.setMajor(major);
//		}
//		String phoneNumber = httpServletRequest.getParameter("phoneNumber");
//		if (phoneNumber != null) {
//			personInfo.setPhoneNumber(phoneNumber);
//		}
		try {
			personInfo = personalInfoService.update(personInfo);
			personalInfoVO = PersonalInfoDAOtoVO.personalInfoDAOtoVO(personInfo);
			return ResultVOUtil.success(personalInfoVO);
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
		}
		
	}
	
	@RequestMapping("/findSelf")
	public ResultVO<PersonalInfoVO> findSelfPersonalInfo(HttpServletRequest httpServletRequest) throws Exception {
		Integer id = getId(httpServletRequest);
		//if user session not exist which means the user did not log in
		if (id == -1) {
			//return an error message
			return ResultVOUtil.error(ResultEnum.USER_NOT_LOGIN);
		}
		try {
			PersonalInfoVO personalInfoVO = PersonalInfoDAOtoVO.personalInfoDAOtoVO(personalInfoService.findById(id));
			return ResultVOUtil.success(personalInfoVO);
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
		}
	}
	
	//Reserved
	@RequestMapping("/findAll")
	public ResultVO<PersonalInfoVO> findAllPersonalInfo() {
		return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
		//return personalInfoService.findAll();
	}
	
	private Integer getId(HttpServletRequest httpServletRequest) throws Exception {
		Integer id = -1;
		//get user's cookies
			Cookie[] cookies = httpServletRequest.getCookies();
			String userRedisKey = "";
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loveinDC_token")) {
					userRedisKey = "UserKey:tk" + cookie.getValue();
					break;
				}
			}
			//get user session from redis
			String serializedUser = "";
			if(stringRedisTemplate.hasKey(userRedisKey)) {
				serializedUser = stringRedisTemplate.opsForValue().get(userRedisKey);
			} else {
				return -1;
				//throw new Exception();
			}
			
			UserSession userSession = RedisSerialization.antiSerialization(serializedUser, UserSession.class);
			
			//get user id
			if (userSession == null) {
				return -1;
				//throw new Exception();
			} else {
				id = userSession.getId();
			}
		return id;
	}
}
