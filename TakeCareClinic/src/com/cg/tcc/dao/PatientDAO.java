package com.cg.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.tcc.bean.PatientBean;
import com.cg.tcc.exception.TakeCareClinicException;
import com.cg.tcc.utility.JdbcUtility;
public class PatientDAO implements IPatientDAO {
	static Logger logger = Logger.getLogger(PatientDAO.class);

	Connection connection = null;
	PreparedStatement statement = null;
	@Override
	public int getId(PatientBean patient) throws TakeCareClinicException {
		// TODO Auto-generated method stub
		logger.info("in fix appoiment method..");

		int patientId = 0;

		connection = JdbcUtility.getConnection();
		try {
				statement = connection.prepareStatement(QueryConstants.insertQuery);
				statement.setString(1, patient.getPatientname());
				statement.setInt(2, patient.getAge());
				statement.setLong(3, patient.getPhone());
				statement.setString(4, patient.getDescription());
				
				statement.executeUpdate();

				statement = connection.prepareStatement(QueryConstants.getIdQuery);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();

				patientId = resultSet.getInt(1);

			} catch (SQLException e) {
				logger.error("statement not created..");
				//throw new TakeCareClinicException("statement not created");
				e.printStackTrace();

			}
		 
	

		return patientId;
	}
	@Override
	public PatientBean getPatientById(int id) throws TakeCareClinicException {
		// TODO Auto-generated method stub
		//List<PatientBean> list=new ArrayList<PatientBean>();
		logger.info("in fix appoiment method..");

		
		connection = JdbcUtility.getConnection();
		PatientBean p;
		try{
			statement = connection.prepareStatement(QueryConstants.selectQuery);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
				p=new PatientBean();
				p.setPatientId(resultSet.getInt(1));
				p.setPatientname(resultSet.getString(2));
				p.setAge(resultSet.getInt(3));
				p.setPhone(resultSet.getLong(4));
				p.setDescription(resultSet.getString(5));
				p.setConsultationDate(resultSet.getDate(6));
				
			return p;
			
			
		}
		catch(SQLException e)
		{
			logger.error("statement not created..");
			throw new TakeCareClinicException("statement not created");
		}
		
		
	}

}
