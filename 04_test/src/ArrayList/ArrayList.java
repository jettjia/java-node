package ArrayList;

public class ArrayList {
	public static void main(String[] args) {
		double m = max(30.1, 40, -5);
		System.out.println(m);
	}
	public static double max(double... values) {
		double largest = Double.NEGATIVE_INFINITY;
		for (double v : values) {
			if (v > largest) {
				largest = v;
			}
		}
		return largest;
	}
}
