package other;

import java.util.Arrays;

public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    
    public static boolean checkInclusion(String shortString, String longString) {
        char[] longArray = longString.toCharArray();
        
        for (int i = 0; i < longArray.length - shortString.length() + 1; i++) {
            String sub = longString.substring(i, i + shortString.length());
            if (isPermutation(sub, shortString))
                return true;
        }
        
        return false;
    }
    
    private static boolean isPermutation(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        return Arrays.equals(a1, a2);
    }
}
