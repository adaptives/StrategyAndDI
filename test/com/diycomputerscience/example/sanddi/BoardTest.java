package com.diycomputerscience.example.sanddi;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

	private Board board;
	//Note: Why have we not declared this as PersistenceStrategy ? See the test methods for the reason ...
	private MockPersistenceStrategy mockPersistenceStrategy;
	
	@Before
	public void setUp() {
		this.mockPersistenceStrategy = new MockPersistenceStrategy();
		this.board = new Board(this.mockPersistenceStrategy);
	}
	
	public void testInstance() throws Exception {
		assertNotNull(this.board.getState());
	}
	
	@Test
	public void testLoad() throws Exception {
		this.board.load();
		this.mockPersistenceStrategy.verifyLoad();
	}
	
	@Test
	public void testSave() throws Exception {
		BoardState state = this.board.getState();
		this.board.save();
		this.mockPersistenceStrategy.verifySave(state);
	}

}
