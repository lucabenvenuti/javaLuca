package textana;

import java.io.IOException;
import java.util.stream.Stream;

public class First {

	public static void main(String[] args) {
	try {
		Stream<String> lines = java.nio.file.Files.lines(java.nio.file.Paths.get("sampletext.txt"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}

}
