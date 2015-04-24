package textana;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class First {

	public static void main(String[] args) {
	Path path = java.nio.file.Paths.get("sampletext.txt");
	//Stream<String> lines = java.nio.file.Files.lines(java.nio.file.Paths.get("sampletext.txt"));
	System.out.println(path);
	try {
		Stream<String> string1 = java.nio.file.Files.lines(path);
		System.out.println(string1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
