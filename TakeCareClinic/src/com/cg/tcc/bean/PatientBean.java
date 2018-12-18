package com.cg.tcc.bean;

import java.sql.Date;

public class PatientBean {

	private int patientId;
	private String patientname;
	private int age;
	private long phone;
	private String description;
	private Date consultationDate;
	
	public PatientBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientBean(int patientId, String patientname, int age, long phone, String description,
			Date consultationDate) {
		super();
		this.patientId = patientId;
		this.patientname = patientname;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultationDate = consultationDate;
	}
	public PatientBean(String patientname, int age, long phone, String description, Date consultationDate) {
		super();
		this.patientname = patientname;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultationDate = consultationDate;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getConsultationDate() {
		return consultationDate;
	}
	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}
	
	
}
