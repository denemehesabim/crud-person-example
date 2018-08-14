package com.farukgenc.person.web.resources;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResource implements Serializable {

	private static final long serialVersionUID = -1912796093646278939L;

	@JsonProperty(value = "success code")
	private String successCode;

	@JsonProperty(value = "desciprtion")
	private String description;

	public String getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(String successCode) {
		this.successCode = successCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
