package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sentences {
	private static Set<String> funnySentences(String sentences, Set<String> keys) {
		Set<String> noDuplicates = new HashSet<>();
        List<String> splitSentences = Arrays.asList(sentences.split("\\."));
        for (String sentence : splitSentences) {
            if (!containsAll(sentence, keys))
                continue;

            List<String> words = Arrays.asList(sentence.split(" "));
            for (String word : words) {
                if (!keys.contains(word)) {
                    noDuplicates.add(word);
                }
            }
        }
        return noDuplicates;
    }
	
	private static boolean containsAll(String sentence, Set<String> keys) {
		for (String key : keys) {
			if (!sentence.contains(key))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String sentences = "the short story is very good."
				+ "a short story is not good."
				+ "while the short story from a common pool."
				+ "short good story writers may define."
				+ "short good.";
		Set<String> keys = new HashSet<>();
		keys.add("short");
		keys.add("good");
		keys.add("story");
		System.out.println(funnySentences(sentences, keys));
	}
	
}
