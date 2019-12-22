package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files
 */
public class Logs {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] orderedLogs = reorderLogFiles(logs);
        for (String log : orderedLogs)
            System.out.println(log);
    }
    
    public static String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            String[] words = log.split(" ");
            if (!isNumeric(words[1])) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }
        letterLogs.sort(new Comparator<String>() {
            public int compare(String str1, String str2) {
                int result = str1.substring(str1.indexOf(" ")).compareTo(str2.substring(str2.indexOf(" ")));
                if (result != 0)
                    return result;
                else
                    return str1.compareTo(str2);
            }
        });
        
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
    
    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
