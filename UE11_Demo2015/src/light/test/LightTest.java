package light.test;

import light.model.Light;

public class LightTest {

	public static void main(String[] args) {
		Light light = Light.OFF;
		System.out.println(light.toString());
		System.out.println(light.name());
		System.out.println(light.toString());
	}

}
