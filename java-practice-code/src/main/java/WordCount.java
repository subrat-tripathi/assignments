import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String, Integer> phrase(String phrase) {
        Map<String, Integer> wordCount = new HashMap<>();
        String word = "";
        for (char ch : phrase.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || ch == '\'') {
                word = word + ch;
            } else {
                populateCountMap(word, wordCount);
                word = "";
            }

        }
        populateCountMap(word, wordCount);
        return wordCount;
    }

    public void populateCountMap(String word, Map<String, Integer> wordCount) {
        if (!"".equals(word.trim())) {
            word = (word.startsWith("'") && word.endsWith("'")) ? word.substring(word.indexOf("'") + 1, word.lastIndexOf("'")) : word ;
            if (!wordCount.containsKey(word.trim().toLowerCase())) {
                wordCount.put(word.trim().toLowerCase(), 0);
            }
            int count = wordCount.get(word.trim().toLowerCase());
            count = count + 1;
            wordCount.put(word.trim().toLowerCase(), count);
        }
    }

}
