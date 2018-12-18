package com.cg.tcc.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.tcc.bean.PatientBean;
import com.cg.tcc.exception.TakeCareClinicException;
import com.cg.tcc.service.IPatientService;
import com.cg.tcc.service.PatientService;

public class Client {
	static Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("resources/log4j.properties");
		logger.info("log4j file loaded...");

		Scanner scanner = new Scanner(System.in);
		IPatientService service = new PatientService();
		System.out.println("welcome to  Health carew Application");
		System.out.println("1.Add patient information");
		System.out.println("2.Search patient by Id");
		System.out.println("3.Exit");
		System.out.println("Select ur choice");
		int choice = 0;
		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("enter only digits");
			System.exit(0);
		}
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.println("Enter name:");
			String name = scanner.nextLine();
			System.out.println("Enter Age:");
			int age = 0;
			try {
				age = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("phone number should contain only digits");
				System.exit(0);
			}
			System.out.println("Enter MobileNumber:");
			long phone = 0;
			try {
				phone = scanner.nextLong();
			} catch (InputMismatchException e) {
				System.err.println("phone number should contain only digits");
				System.exit(0);
			}
			scanner.nextLine();
			System.out.println("Description of problem");
			String problemName = scanner.nextLine();

			PatientBean patient = new PatientBean();
			patient.setPhone(phone);
			patient.setPatientname(name);
			patient.setDescription(problemName);
			patient.setAge(age);

			try {
				boolean result = service.validateDetails(patient);

				if (result) {
					int patientId = service.getId(patient);
					System.out.println("ur appoiinment fixed with the id: " + patientId);
				}

			} catch (TakeCareClinicException e) {
				System.err.println(e.getMessage());
			}
			break;

		case 2:
			System.out.println("Enter id");
			int id = scanner.nextInt();

			try {
				PatientBean p = service.getPatientById(id);
				System.out.println("---------------------");
				System.out.println("id :" + id);
				System.out.println("name :" + p.getPatientname());
				System.out.println("Age :" + p.getAge());
				System.out.println("Phone :" + p.getPhone());
				System.out.println("Description :" + p.getDescription());
				System.out.println("Description :" + p.getConsultationDate());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			// System.out.println(p.getAge());

			break;

		}
	}

}
