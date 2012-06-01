package com.diycomputerscience.example.sanddi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface FileConnectionFactory {
	
	public PrintWriter getWriter() throws IOException;
	public BufferedReader getReader() throws IOException;
	
}
