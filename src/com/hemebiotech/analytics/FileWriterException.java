package com.hemebiotech.analytics;

public class FileWriterException extends Exception {

	/**
	 * G�re les exceptions si le flux n'a pas pu �tre �cris correctement
	 */
	private static final long serialVersionUID = 1L;
	public FileWriterException(){
	}
	
	public FileWriterException(String message){
		super(message);
	}
}
