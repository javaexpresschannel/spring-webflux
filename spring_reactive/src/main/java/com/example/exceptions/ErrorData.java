package com.example.exceptions;

import lombok.Data;

@Data
public class ErrorData {

	private String status;
	private String code;
	private String message;
	private String id;
}
