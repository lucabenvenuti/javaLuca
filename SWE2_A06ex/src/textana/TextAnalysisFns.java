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

public class TextAnalysisFns {

	/**
	 * @param fileName
	 * @param word
	 * @return
	 * @throws IOException
	 *             (a) find the first line which contains a particular word
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
	 *             (a) find lines which contain a particular word
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
	 *             (b) find the number of the line which contains a text and
	 *             return as an optional
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
	 *             (b) find all line numbers which contain a text and return
	 *             them in a list
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
	 *             (c) all words
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
	 *             (d) word occurrences
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
	 *             (e) set of words
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
	 *             (f) grouping words alphabetically
	 */
	public static Map<Character, List<String>> groupByFirstChar(String fileName)
			throws IOException {
		return Files.lines(Paths.get(fileName)).map(line -> line.toLowerCase())
				.map(line -> line.replaceAll("[^a-z ]", ""))
				.map(line -> line.split(" ")).flatMap(Arrays::stream)
				.filter(w -> !w.equals("")).collect(Collectors.groupingBy(w ->
				w.charAt(0), Collectors.mapping(w -> w, Collectors.toList())));
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             (f) grouping words by length
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
