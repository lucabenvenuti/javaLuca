package textana;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

public class TextAnalysisFns {

	private final static List<String> numberList = Arrays.asList("zero", "one",
			"two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "");

	// (a) find lines which contains a particular word

	public static Optional<String> findLine(String fileName, String word)
			throws IOException {
		return Files.lines(Paths.get(fileName)).filter(l -> l.contains(word))
				.findFirst();
	}

	public static List<String> findLines(String fileName, String word)
			throws IOException {
		return Files.lines(Paths.get(fileName)).filter(l -> l.contains(word))
				.collect(Collectors.toList());
	}

	// (b) find all line numbers which contain a text and return them in a list

	public static Optional<Integer> findLineNum(String fileName, String word)
			throws IOException {

		Supplier<Integer> counter = new Supplier<Integer>() {
			int line = 0;

			@Override
			public Integer get() {
				return new Integer(line++);
			}
		};

		return Files.lines(Paths.get(fileName))
				.map(x -> new Pair<>(counter.get(), x))
				.filter(p -> p.scd.contains(word)).map(x -> x.fst).findFirst();
	}

	public static List<Integer> findLineNums(String fileName, String word)
			throws IOException {
		Supplier<Integer> counter = new Supplier<Integer>() {
			int line = 0;

			@Override
			public Integer get() {
				return new Integer(line++);
			}
		};

		return Files.lines(Paths.get(fileName))
				.map(x -> new Pair<>(counter.get(), x))
				.filter(p -> p.scd.contains(word)).map(x -> x.fst)
				.collect(Collectors.toList());
	}

	// (c) all words

	public static List<String> words(String fileName) throws IOException {
		return Files.lines(Paths.get(fileName)).map(line -> line.split(" "))
				.flatMap(Arrays::stream).filter(w -> !numberList.contains(w))
				.collect(Collectors.toList());
	}

	// (d) word occurrences

	public static Map<String, Integer> wordOccurrences(String fileName)
			throws IOException {

		Map<String, List<String>> test = Files.lines(Paths.get(fileName))
				.map(line -> line.split(" ")).flatMap(Arrays::stream)
				.filter(w -> !numberList.contains(w)).map(w -> w.toLowerCase())
				.collect(Collectors.groupingBy(e -> e.toString()));

		/*
		 * .collect( () -> new TreeMap<>(), //(l, e) ->
		 * l.put(e,words(fileName).filter(w -> w.contains(e)).count()), (l, e)
		 * -> l.put(e, ), (l1, l2) -> l1.putAll(l2));
		 */// return null;

		return null;
	}

	// (e) set of words

	public static Set<String> setOfWords(String fileName) throws IOException {
		// TODO
		return null;
	}

	// (f) grouping alphabetically and by length

	public static Map<Character, List<String>> groupByFirstChar(String fileName)
			throws IOException {
		// TODO
		return null;
	}

	public static Map<Integer, List<String>> groupByLength(String fileName)
			throws IOException {
		// TODO
		return null;
	}

}
