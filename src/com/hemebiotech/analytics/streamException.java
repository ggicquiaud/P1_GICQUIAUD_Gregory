package com.hemebiotech.analytics;

public class streamException extends Exception {

	/**
	 * Gère les exceptions si le flux n'a pas pu être lu correctement
	 */
	private static final long serialVersionUID = 1L;
	public streamException(){
	}
	
	public streamException(String message){
		super(message);
	}
}
