package com.diycomputerscience.example.sanddi;

public class Board {
	
	private PersistenceStrategy persistenceStrategy;
	private BoardState state;
	
	public Board(PersistenceStrategy persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
		this.state = new BoardState();
	}
	
	//various methods of playing the board game
	
	public void load() throws PersistenceException {
		this.state = this.persistenceStrategy.load();
	}
	
	public void save() throws PersistenceException {
		this.persistenceStrategy.save(this.state);
	}
	
	public BoardState getState() {
		//TODO: Refactor to clone the state
		return this.state;
	}
}
