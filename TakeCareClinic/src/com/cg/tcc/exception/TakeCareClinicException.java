package com.cg.tcc.exception;
public class TakeCareClinicException extends Exception {

	private String message;

	public TakeCareClinicException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
