package test;

import java.io.IOException;

public class First {

	public static void main(String[] args) {
	try {
		java.nio.file.Files.lines(java.nio.file.Paths.get("sampletext.txt"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}

}
