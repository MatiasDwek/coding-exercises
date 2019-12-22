package leetcode;

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {
	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
			String s = "";
			
			if (i % 3 == 0) {
				s += "Fizz";
			}
			
			if (i % 5 == 0) {
				s += "Buzz";
			}
			
			if (s.equals(""))
				System.out.println(i);
			else
				System.out.println(s);
			
		}
	}
	
	
}
