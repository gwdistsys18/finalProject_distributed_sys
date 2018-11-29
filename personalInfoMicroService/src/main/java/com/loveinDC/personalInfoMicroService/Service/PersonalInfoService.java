package com.loveinDC.personalInfoMicroService.Service;

import java.util.List;

import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;

public interface PersonalInfoService {
	//find infomation by uid
	PersonalInfo findByUid(Integer uid);
	//create Personal information record
	PersonalInfo create(PersonalInfo personInfo);
	//delet a personal information record by uid
	int delete(Integer uid);
	//Get all personal information
	List<PersonalInfo> findAll();
	//update personal information
	PersonalInfo update(PersonalInfo personInfo);
}
