package cyber.main;

import java.util.Random;

public class Util {
	static Random random = new Random();
	public static int chooseInt(int...ints){
		return ints[random.nextInt(ints.length)];
	}
}
