package com.loveinDC.personalInfoMicroService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_PersonalInfo")
public class PersonalInfo {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "nickName")
	private String nickName ;
	@Column(name = "birthDate", length = 10)
	private String birthDate;
	@Column(name = "gender")
	private Character gender;
	@Column(name = "phoneNumber", length = 20)
	private String phoneNumber;
	@Column(name = "college")
	private String college;
	@Column(name = "major", length = 30)
	private String major;
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	//ToString
	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickName="
				+ nickName + ", birthDate=" + birthDate + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", college=" + college + ", major=" + major + "]";
	}
	
	//Constructor
	public PersonalInfo() {
		
	}

}
