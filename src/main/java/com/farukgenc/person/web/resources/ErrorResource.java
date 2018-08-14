package com.farukgenc.person.web.resources;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResource implements Serializable {

	private static final long serialVersionUID = -6539520707273636096L;

	@JsonProperty(value = "error_code")
	private String error;

	@JsonProperty(value = "error_description")
	private String desc;

	public ErrorResource(String error, String desc) {
		super();
		this.error = error;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getError() {
		return error;
	}

}
