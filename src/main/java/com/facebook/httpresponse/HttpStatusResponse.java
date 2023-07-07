package com.facebook.httpresponse;

public class HttpStatusResponse {
	private int statusCode;
	private Object data;
	private String message;

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

	public static HttpStatusResponse setHttpResponse(int code, Object data, String message) {
		HttpStatusResponse httpResponse = new HttpStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setData(data);
		httpResponse.setMessage(message);
		return httpResponse;
	}
public static HttpStatusResponse setFailedResponse(int code,Object data,String message) {
	HttpStatusResponse httpResponse = new HttpStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setMessage(message);
		httpResponse.setData(data);
		return httpResponse;
	}	
}
