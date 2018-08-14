package com.farukgenc.person.exception;

public class DepartmentNotFoundException extends Exception {

	private static final long serialVersionUID = 6779917851169430441L;

	private String errorCode;
	private String description;

	public DepartmentNotFoundException(String errorCode, String description) {
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
