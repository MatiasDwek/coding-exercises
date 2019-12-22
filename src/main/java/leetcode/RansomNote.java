package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note
 * Also on Cracking the Coding Interview
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineLetters = new HashMap<>();
        char[] magazineChars = magazine.toCharArray();
        for (char magazineChar : magazineChars) {
        	Integer charCount = magazineLetters.get(magazineChar);
        	if (charCount == null)
        		magazineLetters.put(magazineChar, 1);
        	else
        		magazineLetters.put(magazineChar, charCount+1);
        }
        
        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char ransomNoteChar : ransomNoteChars) {
        	Integer charCount = magazineLetters.get(ransomNoteChar);
        	if (charCount == null || charCount.equals(0))
        		return false;
        	else
        		magazineLetters.put(ransomNoteChar, charCount-1);
        }
        return true;
    }
}
