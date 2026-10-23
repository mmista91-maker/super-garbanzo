import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class WordCount {
    public Map<String, Integer> phrase(String input) {

        Map<String, Integer> wordCounts = new HashMap<>();

        Pattern pattern = Pattern.compile("[a-z0-9]+(?:'[a-z0-9]+)*");
        Matcher matcher = pattern.matcher(input.toLowerCase());

        while (matcher.find()) {
            String word = matcher.group();

            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }

        return wordCounts;
    }
}