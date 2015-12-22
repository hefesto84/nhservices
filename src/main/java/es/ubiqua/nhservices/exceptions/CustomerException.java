package es.ubiqua.nhservices.exceptions;

public class CustomerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerException(){
		
	}
	
	@Override
	public String getMessage(){
		return "UserException error";
	}
}
