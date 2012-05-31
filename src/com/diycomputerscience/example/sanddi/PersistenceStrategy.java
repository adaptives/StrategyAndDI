package com.diycomputerscience.example.sanddi;

public interface PersistenceStrategy {
	public void save(BoardState state) throws PersistenceException;
	public BoardState load()  throws PersistenceException;
}
