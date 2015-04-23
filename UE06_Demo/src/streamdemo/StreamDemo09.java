package streamdemo;

import inout.Out;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo09 {
	
	// ==== quantifiers ===================================================
	
	public static void main(String[] args) {
		
		Stream<String> names;

		// --- noneMatch ---------------------------------------------------
		
		names = Stream.of("Ann", "Pat", "Mary", "Joe", "John");
		
		boolean noneEmpty = names.noneMatch(na -> na.length() == 0);
		
		Out.println("None empty: " + noneEmpty);

		// --- allMatch ---------------------------------------------------
		
		names = Stream.of("Ann", "Pat", "Mary", "joe", "John");
		
		boolean allUpperCase = names.allMatch(na -> na.length() > 0
				&& Character.isUpperCase(na.charAt(0)));
		
		Out.println("All upper case: " + allUpperCase);
		
		// --- anyMatch ---------------------------------------------------
		
		names = Stream.of("Ann", "Pat", "Mary", "joe", "John");
		
		boolean anyUpperCase = names.anyMatch(na -> na.length() > 0
				&& Character.isUpperCase(na.charAt(0)));
		
		Out.println("All upper case: " + anyUpperCase);
	}

}
