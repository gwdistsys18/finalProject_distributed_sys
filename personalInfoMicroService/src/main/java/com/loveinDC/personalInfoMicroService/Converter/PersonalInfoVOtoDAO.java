package com.loveinDC.personalInfoMicroService.Converter;

import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;
import com.loveinDC.personalInfoMicroService.VO.PersonalInfoVO;

public class PersonalInfoVOtoDAO {
	public static PersonalInfo personalInfoDAOtoVO (PersonalInfo personalInfo, PersonalInfoVO personalInfoVO) {
		if (personalInfoVO.getFirstName() != null) {
			personalInfo.setFirstName(personalInfoVO.getFirstName());
		}
		if (personalInfoVO.getLastName() != null) {
			personalInfo.setLastName(personalInfoVO.getLastName());
		}
		if (personalInfoVO.getBirthDate() != null) {
			personalInfo.setBirthDate(personalInfoVO.getBirthDate());
		}
		if (personalInfoVO.getCollege() != null) {
			personalInfo.setCollege(personalInfoVO.getCollege());
		}
		if (personalInfoVO.getGender() != null) {
			personalInfo.setGender(personalInfoVO.getGender());
		}
		if (personalInfoVO.getMajor() != null) {
			personalInfo.setMajor(personalInfoVO.getMajor());
		}
		if (personalInfoVO.getNickName() != null) {
			personalInfo.setNickName(personalInfoVO.getNickName());
		}
		if (personalInfoVO.getPhoneNumber() != null) {
			personalInfo.setPhoneNumber(personalInfoVO.getPhoneNumber());
		}
		return personalInfo;
	}
}
