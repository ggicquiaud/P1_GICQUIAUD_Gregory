package com.hemebiotech.analytics;

public class streamException extends Exception {

	/**
	 * G�re les exceptions si le flux n'a pas pu �tre lu correctement
	 */
	private static final long serialVersionUID = 1L;
	public streamException(){
	}
	
	public streamException(String message){
		super(message);
	}
}
