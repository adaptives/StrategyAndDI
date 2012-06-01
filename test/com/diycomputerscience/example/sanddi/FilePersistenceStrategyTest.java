package com.diycomputerscience.example.sanddi;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilePersistenceStrategyTest {

	private PrintWriter writer;
	private BufferedReader reader;
	private FileConnectionFactory fileConnectionFactory;
	private FilePersistenceStrategy filePersistenceStrategy;
	
	
	@Before
	public void setUp() throws Exception {		
		this.writer = createMock(PrintWriter.class);
		this.reader =  createMock(BufferedReader.class);
		this.fileConnectionFactory = new MockFileConnectionFactory(writer, reader);
		this.filePersistenceStrategy = new FilePersistenceStrategy(fileConnectionFactory);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() throws Exception {
		//set expectations
		this.writer.println(false);
		this.writer.close();
		//change the mode of our mock to production
		replay(this.writer);
		//create Board
		Board board = new Board(this.filePersistenceStrategy);
		BoardState state = board.getState();
		//invoke method to test
		this.filePersistenceStrategy.save(state);
		
		//ensure our expectations have been fulfilled
		verify(writer);
	}

}
