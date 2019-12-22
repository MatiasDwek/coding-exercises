package other;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitions {
	private static String example = "geeks";
	
	public static void main(String[] args) {
		getPartitions(example);
	}
	
	private static List<String> getPartitions(String s) {
		List<String> partitions = new ArrayList<>();
		String onePartitions = "";
		
		for (int i = 0; i < s.length(); i++) {
			int progression = i;
			while (s.charAt(i) == s.charAt(s.length() - progression)) {
			}
		}
		
		return partitions;
		
	}
}
