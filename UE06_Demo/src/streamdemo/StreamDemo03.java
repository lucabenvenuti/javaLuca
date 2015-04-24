package streamdemo;

import inout.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo03 {
	
	// ==== find, distinct, sort =============================================

	public static void main(String[] args) {
		
		List<String> words = new ArrayList<String>();
		words.add("A");
		words.add("B");
		words.add("C");
		words.add("D");
		words.add("E");
		words.add("B");
		words.add("C");

		// ----  find --------------------------------------------------------

		// findFirst and findAny will just return an Optional of
		// arbitrary/first element when available
		Stream<String> wordStream = words.stream();
		Optional<String> anyWord = wordStream.findAny();
		
		wordStream = words.stream();
		Optional<String> firstWord = wordStream.findFirst();

		if (anyWord.isPresent()) {
			Out.println("Word = " + anyWord.get());
		} else {
			Out.println("No word");
		}

		Out.println(firstWord.orElse("No word"));

		// ----  distinct ----------------------------------------------------
		
		// distinct: compare all elements and remove duplicates using equal
		wordStream = words.stream();
		Stream<String> noDuplicates = wordStream.distinct();

		// ----  sorted   ----------------------------------------------------
		
		// sorting: using natural order (= Comparable)
		Stream<String> wordsSorted = noDuplicates.sorted();

		// ----  reduce to string --------------------------------------------
		System.out.println("test");
		// building string
		String wordsStr = wordsSorted.reduce("", (a, b) -> a + " " + b);
		Out.println("Words: " + wordsStr);

		// ----  building chains ---------------------------------------------
		
		// building chains of functions: VERY IMPORTANT!
		wordStream = words.stream();
		String ws = wordStream
						.distinct()
						.sorted()
						.reduce("", (a, b) -> a + " " + b);
		Out.println("Words: " + ws);
	}

}
