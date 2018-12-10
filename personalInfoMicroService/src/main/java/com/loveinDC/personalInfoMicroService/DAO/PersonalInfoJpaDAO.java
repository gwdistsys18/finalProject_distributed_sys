package com.loveinDC.personalInfoMicroService.DAO;

import com.loveinDC.personalInfoMicroService.Entity.PersonalInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonalInfoJpaDAO extends JpaRepository<PersonalInfo,Long> {
	PersonalInfo findById(Integer id);
	PersonalInfo save(PersonalInfo personInfo);
	List<PersonalInfo> findAll();
	@Modifying
	@Transactional
	@Query("delete from PersonalInfo pi where pi.id = ?1")
	int deleteById(Integer id);
}
