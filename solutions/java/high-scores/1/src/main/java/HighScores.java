import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class HighScores {

    private List<Integer> highScores;
    

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        return Collections.max(highScores);
    }

    List<Integer> personalTopThree() {
        List<Integer> sortedScores = new ArrayList<>(highScores);
        Collections.sort(sortedScores, Collections.reverseOrder());        
        int end = Math.min(3, sortedScores.size());
        return sortedScores.subList(0, end);
    }

}
