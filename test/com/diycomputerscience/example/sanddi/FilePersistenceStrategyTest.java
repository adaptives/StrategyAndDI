package com.diycomputerscience.example.sanddi;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

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
	private Board board;
	
	
	@Before
	public void setUp() throws Exception {		
		this.writer = createMock(PrintWriter.class);
		this.reader =  createMock(BufferedReader.class);
		this.fileConnectionFactory = new MockFileConnectionFactory(writer, reader);
		this.filePersistenceStrategy = new FilePersistenceStrategy(fileConnectionFactory);
		this.board = new  Board(this.filePersistenceStrategy);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() throws Exception {
		//set expectations on mock object
		this.writer.println(false);
		this.writer.close();
		//change the mode of our mock to production
		replay(this.writer);
		
		//invoke method to test
		this.filePersistenceStrategy.save(this.board.getState());
		
		//ensure our expectations have been fulfilled
		verify(writer);
	}
	
	@Test
	public void testLoad() throws Exception {
		//set expectations on mock object
		expect(this.reader.readLine()).andReturn("false");
		this.reader.close();
		//change the mode of our mock to production
		replay(this.reader);
		
		//invoke method to test
		BoardState actual = this.filePersistenceStrategy.load();
		
		//verify
		assertEquals(this.board.getState(), actual);
		verify(this.reader);
	}

}
