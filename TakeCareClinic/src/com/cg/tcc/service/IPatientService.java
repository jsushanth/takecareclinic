package com.cg.tcc.service;

import java.util.List;

import com.cg.tcc.bean.PatientBean;
import com.cg.tcc.exception.TakeCareClinicException;

public interface IPatientService {

	boolean validateDetails(PatientBean patient) throws TakeCareClinicException;

	int getId(PatientBean patient) throws TakeCareClinicException;

	public PatientBean getPatientById(int id) throws TakeCareClinicException;

}
