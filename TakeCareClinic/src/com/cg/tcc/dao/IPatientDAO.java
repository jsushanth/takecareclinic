package com.cg.tcc.dao;

import java.util.List;

import com.cg.tcc.bean.PatientBean;
import com.cg.tcc.exception.TakeCareClinicException;

public interface IPatientDAO {

	

	int getId(PatientBean patient) throws TakeCareClinicException;
	public PatientBean getPatientById(int id) throws TakeCareClinicException;

}
