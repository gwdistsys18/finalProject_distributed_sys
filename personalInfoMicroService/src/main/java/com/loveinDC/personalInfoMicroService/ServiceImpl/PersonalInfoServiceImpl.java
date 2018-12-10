package com.loveinDC.personalInfoMicroService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loveinDC.personalInfoMicroService.DAO.PersonalInfoJpaDAO;
import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;
import com.loveinDC.personalInfoMicroService.Service.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

	@Autowired
	private PersonalInfoJpaDAO personalInfoJpaDao;
	
	@Override
	public PersonalInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return personalInfoJpaDao.findById(id);
	}

	@Override
	public PersonalInfo create(PersonalInfo personInfo) {
		// TODO Auto-generated method stub
		return personalInfoJpaDao.save(personInfo);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		int i = personalInfoJpaDao.deleteById(id);
		System.out.println("delete" + i);
		if(personalInfoJpaDao.findById(id) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<PersonalInfo> findAll() {
		// TODO Auto-generated method stub
		return personalInfoJpaDao.findAll();
	}

	@Override
	public PersonalInfo update(PersonalInfo personInfo) {
		// TODO Auto-generated method stub
		return personalInfoJpaDao.save(personInfo);
	}

}
