package leetcode;

import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("auggiogggg"));
    }
    
    public static int lengthOfLongestSubstring(String s) {
    	if (s.length() == 0)
    		return 0;
    	
        int lengthOfLongest = 1;
        
        for (int i = 0; i < s.length(); i++) {
            Set<Character> candidate = new HashSet<>();
            candidate.add(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
            	if (candidate.contains(s.charAt(j))) {
            		break;
            	} else {
            		candidate.add(s.charAt(j));
            	}
            }
            if (candidate.size() > lengthOfLongest)
    			lengthOfLongest = candidate.size();
        }
        
        return lengthOfLongest;
    }
}
