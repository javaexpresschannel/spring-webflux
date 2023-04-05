package com.example.exceptions;

import java.util.List;

import lombok.Data;

@Data
public class ErrorSource {

	private List<ErrorData> errorData;
}
