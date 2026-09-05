import java.util.Arrays;
import java.util.List;

class ResistorColorTrio {

    private static final List<String> COLORS = Arrays.asList(
        "black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"
    );

    String label(String[] colors) {
        int firstDigit = COLORS.indexOf(colors[0]);
        int secondDigit = COLORS.indexOf(colors[1]);
        int exponent = COLORS.indexOf(colors[2]);

        
        long mainValue = firstDigit * 10 + secondDigit;
        long ohms = mainValue * (long) Math.pow(10, exponent);

        if (ohms >= 1_000_000_000) {
            return (ohms / 1_000_000_000) + " gigaohms";
        } else if (ohms >= 1_000_000) {
            return (ohms / 1_000_000) + " megaohms";
        } else if (ohms >= 1_000) {
            return (ohms / 1_000) + " kiloohms";
        } else {
            return ohms + " ohms";
        }
    }
}