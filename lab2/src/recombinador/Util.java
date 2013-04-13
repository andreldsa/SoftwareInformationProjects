package recombinador;

import java.util.Random;

public class Util {

	public static int sorteia(int max) {
		Random r = new Random();
		final int H = max;
		final int L = 0;
		return (int) (r.nextDouble() * (H - L)) + L;
	}
}
