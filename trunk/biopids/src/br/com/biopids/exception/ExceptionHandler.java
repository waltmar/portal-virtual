package br.com.biopids.exception;

import java.sql.SQLException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class ExceptionHandler {
	
	private static TypeErrors error;
	private String msg="";
	
	
	public ExceptionHandler(){}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static TypeErrors getError() {
		return error;
	}

	public static void setError(TypeErrors error) {
		ExceptionHandler.error = error;
	}
	
	public static ErrorException treatException(Exception e, String msg){
		
		return new ErrorException(getTypeError(e), msg);
	}
	
	public static ErrorException treatException(TypeErrors typeError, String msg){
		return new ErrorException(typeError, msg);
	}		
	
	public static TypeErrors getTypeError(Exception e){
		
		if (e instanceof ClassNotFoundException)
			return TypeErrors.SEVERITY_FATAL;
		else if(e instanceof SQLException)
			return TypeErrors.SEVERITY_ERROR;
		else if(e instanceof ParseException)
			return TypeErrors.SEVERITY_ERROR;
		else if(e instanceof NullPointerException)
			return TypeErrors.SEVERITY_ERROR;
		else return TypeErrors.SEVERITY_INFO;
	}
	
	
	

}
