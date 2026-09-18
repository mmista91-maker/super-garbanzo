import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        int max = a - 'A';
        List<String> diamond = new ArrayList<>();

        
        for (char letter = 'A'; letter <= a; letter++) {

            int i = letter - 'A';
            int outerSpaces = max - i;
            String outer = " ".repeat(outerSpaces);

            String row;

            if (letter == 'A') {
                row = outer + letter + outer;
            } else {
                int innerSpaces = 2 * i - 1;
                String inner = " ".repeat(innerSpaces);

                row = outer + letter + inner + letter + outer;
            }

            diamond.add(row);
        }

        
        for (int i = diamond.size() - 2; i >= 0; i--) {
            diamond.add(diamond.get(i));
        }

        return diamond;
    }
}