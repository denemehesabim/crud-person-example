package com.farukgenc.person.exception;

public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = -6064481390332731788L;

	private String errorCode;
	private String description;

	public PersonNotFoundException(String errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
