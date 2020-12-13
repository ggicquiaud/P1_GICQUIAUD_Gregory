package com.hemebiotech.analytics;

public class FileWriterException extends Exception {

	/**
	 * Gère les exceptions si le flux n'a pas pu être écris correctement
	 */
	private static final long serialVersionUID = 1L;
	public FileWriterException(){
	}
	
	public FileWriterException(String message){
		super(message);
	}
}
