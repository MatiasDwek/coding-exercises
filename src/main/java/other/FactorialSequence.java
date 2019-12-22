package other;

import java.util.ArrayList;
import java.util.List;

public class FactorialSequence {
	private static List<Integer> getSequence(int number) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		for (int i = 2; i <= number; i++) {
			result.add(i * result.get(i-2));
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getSequence(5));
	}
}
