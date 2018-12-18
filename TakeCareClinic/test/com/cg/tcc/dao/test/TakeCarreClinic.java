package com.cg.tcc.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.cg.tcc.bean.PatientBean;
import com.cg.tcc.dao.IPatientDAO;
import com.cg.tcc.dao.PatientDAO;
import com.cg.tcc.exception.TakeCareClinicException;

import oracle.net.aso.p;



public class TakeCarreClinic {

	PatientDAO dao = null;

	@Before
	public void setUp() {
		dao = new PatientDAO();
	}

	@After
	public void tearDown() {
		dao = null;
	}
	@Test
	public void testgetId() {

		PatientBean patient = new PatientBean();
		patient.setPhone(909099876l);
		patient.setAge(21);
		patient.setPatientname("Ravikumar");
		patient.setDescription("asdasd");
	
		
		try {
			Integer id = dao.getId(patient);
			assertNotNull(id);

		} catch (TakeCareClinicException e) {
			e.printStackTrace();
		}
 
	}
	@Test
	public void testgetPatientById()
	{
		IPatientDAO patientDao = new PatientDAO();
		PatientBean p;
		
		try {
			p=patientDao.getPatientById(1);
			assertEquals("Adfghjk", p.getPatientname());
		} catch (TakeCareClinicException e) {
			e.printStackTrace();
		}
		
	}

}
