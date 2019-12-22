package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("aacabbb"));
        System.out.println("a".substring(0, 0));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome(""));
        
        System.out.println(longestPalindrome("addtattarrattatd"));
    }
    
    private static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        
        if (s.length() < 2)
            return s;
        
        for (int i = 0; i < s.length(); i++) {
            int lengthOdd = extendPalindrome(s, i, i); // odd
            int lengthEven = extendPalindrome(s, i, i + 1); // even
            
            int maxIterLength = lengthOdd > lengthEven ? lengthOdd : lengthEven;
            if (maxIterLength > maxLength) {
                start = i - (maxIterLength - 1) / 2;
                end = i + maxIterLength / 2;
                maxLength = maxIterLength;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private static int extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        return end - start - 1;
    }
    
    private static String longestPalindromeBrute(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j+1);
                if (isPalindrome(subString) && subString.length() > longestPalindrome.length()) {
                    longestPalindrome = subString;
                }
            }
        }
        
        return longestPalindrome;
    }
    
    private static String longestPalindromeBrute2(String s) {
        if (isPalindrome(s))
            return s;
        String leftSubstring = longestPalindrome(s.substring(0, s.length() - 1));
        String rightSubstring = longestPalindrome(s.substring(1, s.length()));
        return leftSubstring.length() > rightSubstring.length() ? leftSubstring : rightSubstring;
    }
    
    private static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length/2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
