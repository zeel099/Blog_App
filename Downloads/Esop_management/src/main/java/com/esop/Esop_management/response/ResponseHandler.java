package com.esop.Esop_management.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	
	public static ResponseEntity<Object> responseBuilder(
		String message,
		HttpStatus httpStatus,
		Object responseObject
	){

		Map<String,Object>response = new HashMap<>();
		response.put("meassage", message);
		response.put("status",httpStatus);
		response.put("data", responseObject);

		return new ResponseEntity<>(response,httpStatus);

	}

}
