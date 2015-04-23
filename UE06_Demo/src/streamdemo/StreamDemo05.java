package streamdemo;

import inout.Out;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo05 {
	
	// ==== HOF map, filter, flatMap ===========================================

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// --- map ------------------------------------------------------------
		
		Stream<String> names = Stream.of("Ann", "Pat", "Mary", "Joe");
		
		Stream<String> initials = names.map(a -> initial(a));
		
		Out.println("Initials:");
		initials.forEach(a -> Out.println(a));
		
		names = Stream.of("Ann", "Pat", "Mary", "Joe");
		IntStream nameLengths = names.mapToInt(a -> a.length());
		
		Out.println("Lengths:");
		nameLengths.forEach(a -> Out.println(a));

		// --- filter ---------------------------------------------------------
		
		final Random r = new Random();
		Stream<Integer> posStream = Stream.iterate(0, x -> x + 1);
		
		IntStream evens = posStream
							.limit(100)
							.filter(x -> x % 2 == 0)
							.mapToInt(x -> x);

		// --- find -----------------------------------------------------------

		// ==> SHOULD  BE used together with filter 
		// filter to find elements fulfilling certain predicate
		// find to take first or any of them 
		// !!!! filter is lazy, so no overhead for just finding one element !!!

		IntStream randStream = IntStream.generate(() -> r.nextInt(100));
		
		OptionalInt randGreater97 = randStream
						.filter(x -> x > 97)
						.findFirst();
		
		Out.println(randGreater97.orElse(-1));

		randStream = IntStream.generate(() -> r.nextInt(100));
		
		randGreater97 = randStream
						.filter(x -> x > 97)
						.findAny();
		
		Out.println(randGreater97.orElse(-1));

		// !!! difference between findFirst and findAny for parallel streams !!!
		
		// --- flatMap -----------------------------------------------------------
		
		// used to do mapping and building from stream of streams flat stream

		posStream = Stream.iterate(0, x -> x + 1);
		Out.println("Subsequences 1 to 4:");
		
		IntStream subSeq = 
				posStream
					.limit(5)
					.flatMapToInt(i -> IntStream.iterate(1, j -> j + 1).limit(i));
		
		subSeq.forEach(i -> Out.print(i + " "));

		names = Stream.of("Ann", "Pat", "Mary", "Joe");
		IntStream letters = names.flatMapToInt(w -> w.chars());
		
		Stream<Character> chars = 
				letters
					.mapToObj(i -> new Character((char) i));
		
		System.out.println();
		chars.forEach(c -> System.out.println(c));
		
	}

	private static String initial(String n) {
		return n.substring(0, 1) + ".";
	}
}
