package com.facebook.util;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.facebook.httpresponse.HttpErrorResponse;
import com.facebook.httpresponse.HttpGetStatusResponse;
import com.facebook.httpresponse.HttpUserErrorResponse;
import com.facebook.httpresponse.HttpStatusResponse;

public class ResponseUtil {

	public static ResponseEntity<HttpStatusResponse> prepareSuccessResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(statusCode,payload,mesage),HttpStatus.OK);
	}
	
	public static ResponseEntity<HttpUserErrorResponse> prepareFailedResponse(int statusCode,Map<String,String> map){
		return new ResponseEntity<>(HttpUserErrorResponse.setFailedResponse(statusCode,map),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<HttpGetStatusResponse> prepareHttpResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpGetStatusResponse.setSuccessResponse(statusCode, payload, mesage),HttpStatus.OK);
	}
	public static ResponseEntity<HttpErrorResponse> setCommentFailedResponse(int statusCode,String message){
		return new ResponseEntity<>(HttpUserErrorResponse.setCommentFailedResponse(statusCode,message),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public static ResponseEntity<HttpGetStatusResponse> prepareErrorResponse(int statusCode, String message){
		return new ResponseEntity<>(HttpGetStatusResponse.setFailedResponse(statusCode, message),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}