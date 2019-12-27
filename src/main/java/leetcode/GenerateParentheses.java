package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/generate-parentheses
 * Also exercise 8.9 of cracking the ...
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4).toString());
    }
    
    
    public static List<String> generateParenthesis(int n) {
        Set<String> parenthesis = new HashSet<>();
        if (n == 0)
            return new ArrayList<>();
        parenthesis.add("()");
        return new ArrayList<>(generateParenthesisRec(n, parenthesis));
    }
    
    public static Set<String> generateParenthesisRec(int n, Set<String> prevParen) {
        Set<String> parenthesis = new HashSet<>();
        
        if (n == 1) {
            return prevParen;
        } else {
            for (String s : prevParen) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] == '(')
                        parenthesis.add(s.substring(0, i+1) + "()" + s.substring(i+1));
                }
                parenthesis.add("()" + s);
                parenthesis.add(s + "()");
            }
        }
        
        return generateParenthesisRec(n-1, parenthesis);
    }
    
}
