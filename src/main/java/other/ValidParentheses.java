package other;

import java.util.Stack;

public class ValidParentheses {
	

	public static boolean isValid(String s) {
		Stack<Character> parentheses = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == ')' || c == ']' || c == '}') {
                if (parentheses.isEmpty())
                    return false;
				char charInStack = parentheses.pop();
				if (!isParenthesisComplement(charInStack, c))
					return false;
			} else {
				parentheses.add(c);
			}
		}
		
		return parentheses.isEmpty();
	}
	
	private static boolean isParenthesisComplement(char paren1, char paren2) {
		if (paren1 == '(' && paren2 == ')' || paren1 == ')' && paren2 == '(')
			return true;
		if (paren1 == '[' && paren2 == ']' || paren1 == ']' && paren2 == ']')
			return true;
		if (paren1 == '{' && paren2 == '}' || paren1 == '}' && paren2 == '{')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("((([()])))[]{}"));
	}
}
