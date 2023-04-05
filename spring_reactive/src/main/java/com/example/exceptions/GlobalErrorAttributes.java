package com.example.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
		Map<String, Object> map = super.getErrorAttributes(request, options);
		var throwable = getError(request);
		
		if (throwable instanceof BookNotFoundException) {
			ErrorSource errorSource = new ErrorSource();
		
			List<ErrorData> errorDataList = new ArrayList<>();
			
			ErrorData errorData = new ErrorData();
			errorData.setId(UUID.randomUUID().toString());
			errorData.setCode(HttpStatus.NOT_FOUND.toString());
			errorData.setMessage(throwable.getMessage());
			errorData.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
			errorDataList.add(errorData);
			
			errorSource.setErrorData(errorDataList);
			map.put("errorList", errorSource);
		}
		return map;
	}
}
