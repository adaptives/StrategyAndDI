package com.diycomputerscience.example.sanddi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MockFileConnectionFactory implements FileConnectionFactory {

	private PrintWriter writer;
	private BufferedReader reader;
	
	public MockFileConnectionFactory(PrintWriter writer, BufferedReader reader) {
		this.writer = writer;
		this.reader = reader;
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		return this.writer;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return this.reader;
	}

}
