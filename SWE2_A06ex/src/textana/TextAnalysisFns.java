package textana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * TextAnalysisFns.java
 *
 * A {@link TextAnalysisFns} is a public class. It contains public static
 * methods that can reads a ".txt" file and returns its information.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class TextAnalysisFns {

	/**
	 * @param fileName
	 * @param word
	 * @return
	 * @throws IOException
	 *             (a) findLine: finds and returns as Optional<String> the first
	 *             line which contains a particular word
	 */
	public static Optional<String> findLine(String fileName, String word)
			throws IOException {
		return Files.lines(Paths.get(fileName)).filter(l -> l.contains(word))
				.findFirst();
	}

	/**
	 * @param fileName
	 * @param word
	 * @return
	 * @throws IOException
	 *             (a) findLines: finds and returns as List<String> the lines
	 *             which contain a particular word
	 */
	public static List<String> findLines(String fileName, String word)
			throws IOException {
		return Files.lines(Paths.get(fileName)).filter(l -> l.contains(word))
				.collect(Collectors.toList());
	}

	/**
	 * @param fileName
	 * @param word
	 * @return
	 * @throws IOException
	 *             (b) findLineNum: finds and returns as Optional<Integer the
	 *             number of the first line which contains a text and return as
	 *             an optional
	 */
	public static Optional<Integer> findLineNum(String fileName, String word)
			throws IOException {

		Supplier<Integer> counter = new Supplier<Integer>() {
			int line = 1;

			@Override
			public Integer get() {
				return new Integer(line++);
			}
		};

		return Files.lines(Paths.get(fileName))
				.map(x -> new Pair<>(counter.get(), x))
				.filter(p -> p.scd.contains(word)).map(x -> x.fst).findFirst();
	}

	/**
	 * @param fileName
	 * @param word
	 * @return
	 * @throws IOException
	 *             (b) findLineNums: finds and returns as List<Integer> all line
	 *             numbers which contain a text and return them in a list
	 */
	public static List<Integer> findLineNums(String fileName, String word)
			throws IOException {
		Supplier<Integer> counter = new Supplier<Integer>() {
			int line = 1;

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

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             (c) words: finds and returns as List<String> all the words in
	 *             the order they occur (also twin). Non-words, such as numbers
	 *             are not included in the result. It is case-insensitive.
	 */
	public static List<String> words(String fileName) throws IOException {
		return Files.lines(Paths.get(fileName)).map(line -> line.toLowerCase())
				.map(line -> line.replaceAll("[^a-z ]", ""))
				.map(line -> line.split(" ")).flatMap(Arrays::stream)
				.filter(w -> !w.equals("")).collect(Collectors.toList());
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             (d) word occurrences: which determines how often a word
	 *             appears in the text, ie the results table (as Map<String,
	 *             Integer>) shows for each word how often the Word in the text
	 *             occurs. It is case-insensitive.
	 */
	public static Map<String, Integer> wordOccurrences(String fileName)
			throws IOException {

		return Files
				.lines(Paths.get(fileName))
				.map(line -> line.toLowerCase())
				.map(line -> line.replaceAll("[^a-z ]", ""))
				.map(line -> line.split(" "))
				.flatMap(Arrays::stream)
				.filter(w -> !w.equals(""))
				.collect(
						Collectors.groupingBy(o -> o,
								Collectors.reducing(0, e -> 1, Integer::sum)));
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             (e) setOfWords: determines the set of all words, ie, words
	 *             come in the set only once. It is case-insensitive. Returns a
	 *             sorted TreeSet<String>.
	 */
	public static Set<String> setOfWords(String fileName) throws IOException {

		return Files.lines(Paths.get(fileName)).map(line -> line.toLowerCase())
				.map(line -> line.replaceAll("[^a-z ]", ""))
				.map(line -> line.split(" ")).flatMap(Arrays::stream)
				.filter(w -> !w.equals(""))
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             (f) groupByFirstChar: grouping words alphabetically after the
	 *             first letter. It is case-insensitive. Returns a
	 *             Map<Character, List<String>>.
	 */
	public static Map<Character, List<String>> groupByFirstChar(String fileName)
			throws IOException {
		return Files
				.lines(Paths.get(fileName))
				.map(line -> line.toLowerCase())
				.map(line -> line.replaceAll("[^a-z ]", ""))
				.map(line -> line.split(" "))
				.flatMap(Arrays::stream)
				.filter(w -> !w.equals(""))
				.collect(
						Collectors.groupingBy(w -> w.charAt(0),
								Collectors.mapping(w -> w, Collectors.toList())));
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             (f) groupByLength: grouping words by length. It is
	 *             case-insensitive. Returns a Map<Integer, List<String>>.
	 */
	public static Map<Integer, List<String>> groupByLength(String fileName)
			throws IOException {

		return Files
				.lines(Paths.get(fileName))
				.map(line -> line.toLowerCase())
				.map(line -> line.replaceAll("[^a-z ]", ""))
				.map(line -> line.split(" "))
				.flatMap(Arrays::stream)
				.filter(w -> !w.equals(""))
				.collect(
						Collectors.groupingBy(w -> w.length(),
								Collectors.mapping(w -> w, Collectors.toList())));
	}

}
