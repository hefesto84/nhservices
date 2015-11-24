package es.ubiqua.nhservices.exceptions;

public class CustomerException extends Exception{

	public CustomerException(){
		
	}
	
	@Override
	public String getMessage(){
		return "UserException error";
	}
}
