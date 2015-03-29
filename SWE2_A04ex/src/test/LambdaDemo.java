package test;

import inout.In;
import inout.Out;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.JButton;

@FunctionalInterface
interface Transformer<A, B> {
	
	B transform(A a); 
	
	default B checkNullAndTransform(A a) {
		if (a == null) return null; 
		else return transform(a); 
	}
	
}

public class LambdaDemo {

	public static void main(String[] args) {
		
		// 1) ---- implementing interfaces by lambdas ------------------
		
		ActionListener l = e -> {
			Out.println("Action executed"); 
		};
		
		JButton btn = new JButton("Click"); 
		btn.addActionListener(e -> Out.println("Click clicked")); 
		
		// Iterator<String> it = () -> // not allowed not a SAM interface 
		
		Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2); 
		List<String> names = new ArrayList<String>(); 
		names.add("Hans"); names.add("Susan"); names.add("Ann"); 
		
		Collections.sort(names, c); 
		
		for (String n : names) {
			Out.println(n); 
		}
		
		Collections.sort(names, String::compareToIgnoreCase);  
			// (self, other) -> self.compareToIgnoreCase(other)
		
		// 2) ---- functional interfaces -------------------------------
		
		Transformer<String, String> trimmer = s -> {
			return s.trim(); 
		};
		
		String strg = "         1  word22    3"; 
		String trimmed = trimmer.transform(strg); 
		trimmed = trimmer.checkNullAndTransform(strg); 
		Out.println(trimmed); 
		
		strg = null; 
		trimmed = trimmer.checkNullAndTransform(strg); 
		Out.println(trimmed); 
		
		// 3) ---- functional interfaces from java.util.function -------
		
		Function<String, Integer> length = s -> {
			if (s == null) return 0; 
			else return s.length(); 
		};
		
		Predicate<String> notEmpty = s -> s.length() != 0; 
		
		Consumer<String> writer = s -> {
			Out.println(s); 
		};
		
		Supplier<String> reader = () -> {
			return In.readLine(); 
		};
		
		// 4) ---- using the higher order function ---------------------
		
		doGetTestProcessUse(
				() -> {
					Out.println("Input string: ");
					return In.readLine(); 
				}, 
				s -> s.length() != 0, 
				s -> s.length(), 
				i -> Out.println("Length = " + i)
		); 
		
		// 5) ---- show that functional interfaces 
		//         can be implemented like other interfaces ------------
		
		Function<Integer, Integer> summer = new Function<Integer, Integer>() {
			private int sum = 0;

			@Override
			public Integer apply(Integer i) {
				sum += i;
				return sum; 
			} 
			
		};
		
		// this does not work
//		Function<Integer, Integer> summer2 = (Integer i) -> {
//			int sum = 0; 
//			return sum + i; 
//		};
		
		for (int i = 0; i < 3; i++) {
			doGetTestProcessUse(
					() -> {
						Out.println("Input number: ");
						return In.readInt(); 
					},
					x -> x != 0, 
					summer, 
					sum -> Out.println("Sum = " + sum)
			);
		}
		
	}
	
	
	// 4) ---- writing a higher order function -------------------------
	
	static public <A, B> void doGetTestProcessUse(
			Supplier<A> getter, 
			Predicate<A> condition, 
			Function<A, B> processor, 
			Consumer<B> user) {
		A a = getter.get(); 
		if (condition.test(a)) {
			B b = processor.apply(a); 
			user.accept(b); 
		}
	}

}
