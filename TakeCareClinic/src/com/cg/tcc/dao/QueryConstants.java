package com.cg.tcc.dao;

public interface QueryConstants {

	public static final String insertQuery = "insert into patient values(Patient_Id_Sequence.nextval,?,?,?,?,sysdate)";
	public static final String getIdQuery = "select max(id) from patient";
	public static final String selectQuery = "select * from patient where id= ?";
	

}
