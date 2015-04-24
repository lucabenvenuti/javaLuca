package textana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class First {

	public static void main(String[] args) {
		try {
			Files.lines(Paths.get("stuff.txt"))
            .map(line -> line.split("\\s+")) // Stream<String[]>
            .flatMap(Arrays::stream) // Stream<String>
            .distinct() // Stream<String>
            .forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
