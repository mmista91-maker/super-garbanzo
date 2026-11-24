import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class Anagram {

    private final String wordLower;
    private final char[] sortedWordChars;

    public Anagram(String word) {
        this.wordLower = word.toLowerCase(Locale.ROOT);
        this.sortedWordChars = this.wordLower.toCharArray();
        Arrays.sort(this.sortedWordChars);
    }

    public List<String> match(List<String> candidates) {
            return candidates.stream()
                    .filter(this::isAnagram)
                    .toList();
        }

        private boolean isAnagram(String candidate) {
            String candidateLower = candidate.toLowerCase(Locale.ROOT);
            if (candidateLower.equals(wordLower)) {
                return false;
            }
            char[] candidateChars = candidateLower.toCharArray();
            Arrays.sort(candidateChars);
            return Arrays.equals(candidateChars, sortedWordChars);
        }
    }
