import java.util.Map;
import java.util.List;

class Scrabble {

    private String word;

    private final Map<Integer, List<Character>> values = Map.ofEntries (
        Map.entry(1, List.of('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')),
        Map.entry(2, List.of('D', 'G')),
        Map.entry(3,List.of('B','C','M','P')),
        Map.entry(4,List.of('F','H','V','W','Y')),
        Map.entry(5,List.of('K')),
        Map.entry(8,List.of('J','X')),
        Map.entry(10,List.of('Q','Z'))
    );

    Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        int score = 0;
        for (char letter : word.toCharArray()) {
            for (Map.Entry<Integer, List<Character>> entry : values.entrySet()) {  
                if (entry.getValue().contains(letter)) {
                score += entry.getKey();
                }     
}
}return score;
}
}

