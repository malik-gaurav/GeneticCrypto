package FitnessFunctions;

public class Shannon {
	public static double entropy(int [] chromosome) {
		final int size = 2;
		int [] count = new int [size];
		double H = 0.0; // entropy
		
		for(int i = 0; i < chromosome.length; i++) {
			count[chromosome[i]]++;
		}
		
		H = -1 * (
				count[0]*Math.log(count[0])/Math.log(2)
				+
				count[1]*Math.log(count[1])/Math.log(2)
				);
		
		return H;
	}
}
