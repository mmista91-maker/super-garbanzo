import java.util.Set;
import java.util.HashSet;
import java.util.Random;

class Robot {

    private String name;
    private static final Set<String> usedNames = new HashSet<>();

    Robot() {
        name = nameGenerator();
    }

    String nameGenerator() {
        Random random = new Random();
        String generated;

        do {
            char letter1 = (char) ('A' + random.nextInt(26));
            char letter2 = (char) ('A' + random.nextInt(26));

            int digit1 = random.nextInt(10);
            int digit2 = random.nextInt(10);
            int digit3 = random.nextInt(10);

            generated = "" + letter1 + letter2
                        + digit1 + digit2 + digit3;

        } while (!usedNames.add(generated));

        return generated;
    }

    String getName() {
        return name;
    }

    void reset() {
        name = nameGenerator();
    }
}