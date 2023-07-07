package com.facebook.httpresponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HttpGetStatusResponse {
	private int statusCode;
	private Object data;
	private String message;
	private List<Object> list = new ArrayList<>();

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public static HttpGetStatusResponse setSuccessResponse(int code, Object data, String message) {
		HttpGetStatusResponse successResponse = new HttpGetStatusResponse();
		successResponse.setStatusCode(code);
		successResponse.setData(data);
		successResponse.setMessage(message);
		successResponse.setList(Arrays.asList(data));
		return successResponse;
	}
	
	public static HttpGetStatusResponse setFailedResponse(int code,String message) {
		HttpGetStatusResponse successResponse = new HttpGetStatusResponse();
		successResponse.setStatusCode(code);
		
		successResponse.setMessage(message);
		
		return successResponse;
	}
	
	
}
