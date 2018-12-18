package com.cg.tcc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.tcc.exception.TakeCareClinicException;

//import com.cg.tcc.exceptions.HealthCareException;

public class JdbcUtility {

	private static Connection connection = null;

	public static Connection getConnection() throws TakeCareClinicException
	{

		Properties properties = new Properties();

		File file = new File("resources/jdbc.properties");
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new TakeCareClinicException("File not exists");
		}

		try {
			properties.load(inputStream);

			String driver = properties.getProperty("dr.driver");
			String url = properties.getProperty("db.url");
			String userName = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
			} catch (ClassNotFoundException e) {
				throw new TakeCareClinicException("class not loaded..");
			} catch (SQLException e) {
				throw new TakeCareClinicException("connection not established");
			}

		} catch (IOException e) {
			throw new TakeCareClinicException("no data persent in fiole to read");
		}
		return connection;

	}
}
