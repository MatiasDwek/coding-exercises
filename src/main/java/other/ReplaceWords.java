package other;

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] splittedSentence = sentence.split(" ");
        for (int i = 0; i < splittedSentence.length; i++) {
            for (String dictWord : dict) {
                if (splittedSentence[i].indexOf(dictWord) == 0)
                    splittedSentence[i] = dictWord;
                    
            }
        }
        return String.join(" ", splittedSentence);
    }
}
