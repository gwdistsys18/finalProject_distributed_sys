package com.loveinDC.personalInfoMicroService.Service;

import java.util.List;

import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;

public interface PersonalInfoService {
	//find infomation by id
	PersonalInfo findById(Integer id);
	//create Personal information record
	PersonalInfo create(PersonalInfo personInfo);
	//delet a personal information record by id
	int delete(Integer id);
	//Get all personal information
	List<PersonalInfo> findAll();
	//update personal information
	PersonalInfo update(PersonalInfo personInfo);
}
