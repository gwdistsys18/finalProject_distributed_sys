package com.loveinDC.personalInfoMicroService.Converter;

import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;
import com.loveinDC.personalInfoMicroService.VO.PersonalInfoVO;

public class PersonalInfoDAOtoVO {
	public static PersonalInfoVO personalInfoDAOtoVO (PersonalInfo personalInfo) {
		PersonalInfoVO personalInfoVO = new PersonalInfoVO();
		personalInfoVO.setFirstName(personalInfo.getFirstName());
		personalInfoVO.setLastName(personalInfo.getLastName());
		personalInfoVO.setBirthDate(personalInfo.getBirthDate());
		personalInfoVO.setCollege(personalInfo.getCollege());
		personalInfoVO.setGender(personalInfo.getGender());
		personalInfoVO.setMajor(personalInfo.getMajor());
		personalInfoVO.setNickName(personalInfo.getNickName());
		personalInfoVO.setPhoneNumber(personalInfo.getPhoneNumber());
		return personalInfoVO;
	}
}
