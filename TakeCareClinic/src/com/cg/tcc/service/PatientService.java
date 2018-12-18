package com.cg.tcc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.cg.tcc.bean.PatientBean;
import com.cg.tcc.dao.IPatientDAO;
import com.cg.tcc.dao.PatientDAO;
import com.cg.tcc.exception.TakeCareClinicException;

public class PatientService implements IPatientService {
	IPatientDAO patientDao = new PatientDAO();

	@Override
	public boolean validateDetails(PatientBean patient) throws TakeCareClinicException {

		List<String> list = new ArrayList<>();
		boolean result = false;

		if (!isNameValid(patient.getPatientname())) {
			list.add("name should start with capital letter & length should be greater than 6 and less tah 20");
		}
		if (!isPhonevalid(patient.getPhone())) {
			list.add("phone number exactly 10 digits");
		}
		if (!isProblemValid(patient.getDescription())) {
			list.add("problem name should contain characters");
		}

		if (!list.isEmpty()) {
			result = false;
			throw new TakeCareClinicException(list + "");
		} else {
			result = true;
		}
		return result;
	}
	public boolean isNameValid(String name) {

		String nameRegEx = "[A-Z]{1}[a-zA-Z]{5,20}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public boolean isPhonevalid(long mobileNo) {

		String phoneregEx = "[0-9]{10}";
		Pattern pattern = Pattern.compile(phoneregEx);
		Matcher matcher = pattern.matcher(String.valueOf(mobileNo));
		return matcher.matches();
	}

	public boolean isProblemValid(String problemName) {

		String nameRegEx = "[a-zA-Z]{3,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(problemName);
		return matcher.matches();
	}
	@Override
	public int getId(PatientBean patient) throws TakeCareClinicException {
		// TODO Auto-generated method stub
		return patientDao.getId(patient);
	}
	@Override
	public PatientBean getPatientById(int id) throws TakeCareClinicException {
		// TODO Auto-generated method stub
		return patientDao.getPatientById(id);
	}

}
