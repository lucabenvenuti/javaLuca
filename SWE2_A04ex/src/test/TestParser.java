package test;

public class TestParser {

	public static void main(String[] args) {

	/*	String f = "rect 10 20 30 40";
		System.out.println(f.substring(0, 4).equals("rect"));
		System.out.println(Integer.parseInt(f.substring(5, 7))*2);
		System.out.println(Integer.parseInt(f.substring(8, 10))*2);
		System.out.println(Integer.parseInt(f.substring(11, 13))*2);
		System.out.println(Integer.parseInt(f.substring(14, 16))*2);		*/
		
		String c = "circle 10 20 30";
		System.out.println(c.substring(0, 6).equals("circle"));
		System.out.println(Integer.parseInt(c.substring(7, 9))*2);
		System.out.println(Integer.parseInt(c.substring(10, 12))*2);
		System.out.println(Integer.parseInt(c.substring(13, 15))*2);

	}

}
