package com.diycomputerscience.example.sanddi;

public class PersistenceException extends Exception {
	//Override all constructors from the superclass
	
	public PersistenceException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
