package com.diycomputerscience.example.sanddi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FilePersistenceStrategy implements PersistenceStrategy {

	@Override
	public void save(BoardState state) throws PersistenceException {
		FileWriter writer = getFileWriter();
		//logic to save the state 
		if(writer != null) {
			try {
				writer.close();
			} catch(IOException ioe) {
				String msg = "Could not close FileWriter";
				throw new PersistenceException(msg, ioe);
			}
		}
	}

	@Override
	public BoardState load() throws PersistenceException {
		FileReader reader = getFileReader();
		BoardState state = parseFileForBoardState(reader);
		return state;
	}

	private BoardState parseFileForBoardState(FileReader reader) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * HOW DO I USE INVERSION OF CONTROL HERE FOR BETTER TESTABILITY ?
	 * @return
	 */
	private FileReader getFileReader() {
		// Create a FileReader from a well known file name... 
		// perhaps a hardcoded name or read name from a config file
		return null;
	}

	/**
	 * HOW DO I USE INVERSION OF CONTROL HERE FOR BETTER TESTABILITY ?
	 * @return
	 */
	private FileWriter getFileWriter() {
		// Create a FileWriter from a well known file name... 
		// perhaps a hardcoded name or read name from a config file
		return null;
	}
}
