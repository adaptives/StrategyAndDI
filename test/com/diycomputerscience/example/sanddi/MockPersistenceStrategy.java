package com.diycomputerscience.example.sanddi;

import static org.junit.Assert.*;

public class MockPersistenceStrategy implements PersistenceStrategy {

	private BoardState actualState;
	private boolean loadCalled;
	
	@Override
	public void save(BoardState state) throws PersistenceException {
		this.actualState = state;
	}

	@Override
	public BoardState load() throws PersistenceException {
		this.loadCalled = true;
		return new BoardState();
	}
	
	public void verifySave(BoardState expectedState) throws Exception {
		assertEquals(expectedState, actualState);
	}
	
	public void verifyLoad() throws Exception {
		assertTrue(this.loadCalled);
	}

}
