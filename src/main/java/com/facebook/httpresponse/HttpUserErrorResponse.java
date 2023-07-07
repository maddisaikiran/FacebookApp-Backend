package com.facebook.httpresponse;

import java.util.Map;

public class HttpUserErrorResponse {
	private int statusCode;
	private String message;
	private Map<String,String> errors;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public static HttpUserErrorResponse setFailedResponse(int code, Map<String, String> error) {
		
	HttpUserErrorResponse httpResponse = new HttpUserErrorResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setErrors(error);
		return httpResponse;
	}
public static HttpErrorResponse setCommentFailedResponse(int code, String message) {
HttpErrorResponse httpResponse = new HttpErrorResponse();
httpResponse.setStatusCode(code);
httpResponse.setMessage(message);
return httpResponse;
}	



}
