package textana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		
		 ArrayList<String> seussCountActivities = new ArrayList<String>() { {
		        add("findow");
		        add("Balloons");
		        add("Elephants");
		        add("Boom Bands");
		        add("findow");
		        add("Hakken-Kraks");
		        add("Hakken-Kraks");
		        add("Hakken-Kraks");
		        add("Elephants");
		    }};
		    
		    Map<String, Integer> seussCount = new HashMap<String,Integer>();
		    for(String t: seussCountActivities) {
		       Integer i = seussCount.get(t);
		       if (i ==  null) {
		           i = 0;
		       }
		       seussCount.put(t, i + 1);
		    }
		    
		  //  logger.info(seussCount);
		    seussCount.forEach((k,m) -> System.out.println(k.toString()+Integer.valueOf(m)));
		 //   int numberOfElephants = seussCount.get("Elephants");
		  //  assertEquals(2, numberOfElephants);  
	
	}

}
