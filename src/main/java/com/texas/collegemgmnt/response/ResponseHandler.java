package com.texas.collegemgmnt.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpstatus, Object responseBody) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("Status Code", httpstatus.value());
		map.put("Response Body", responseBody);
		
		return new ResponseEntity<Object>(map, httpstatus);
	}
}
