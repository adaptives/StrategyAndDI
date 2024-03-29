package com.diycomputerscience.example.sanddi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePersistenceStrategy implements PersistenceStrategy {

	private FileConnectionFactory factory;
	
	public FilePersistenceStrategy(FileConnectionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void save(BoardState state) throws PersistenceException {
		PrintWriter writer = null;
		try {
			writer = this.factory.getWriter();
			writer.println(state.isOpen());				
		} catch(IOException ioe) {
			String msg = "Could not save board to file";
			throw new PersistenceException(msg, ioe);
		} finally {			
			if(writer != null) {
				writer.close();
			}			
		}
	}

	@Override
	public BoardState load() throws PersistenceException {
		BufferedReader reader = null;
		try {
			reader = this.factory.getReader();
			String sState = reader.readLine();
			BoardState state = new BoardState();
			state.setOpen(Boolean.parseBoolean(sState));
			return state;
		} catch(IOException ioe) {
			String msg = "Could not load board from file";
			throw new PersistenceException(msg, ioe);
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch(IOException ioe) {
					String msg = "Could not close the reader";
					throw new PersistenceException(msg, ioe);
				}
			}
		}
	}

	
}
