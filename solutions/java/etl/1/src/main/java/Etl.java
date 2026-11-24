import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {

        Map<String, Integer> result = new HashMap<String, Integer>();

        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            int points = entry.getKey();
            for (String letter : entry.getValue()) {
                result.put(letter.toLowerCase(Locale.ROOT), points);

            }
        }
        return result;
    }
}
