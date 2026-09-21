import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Set<Integer> seen = new HashSet<>();

        return phrase.chars()
            .filter(c -> Character.isLetter(c))
            .map(c -> Character.toLowerCase(c))
            .allMatch(c -> seen.add(c));
    }
}