import java.util.Locale;

class RotationalCipher {

    int shiftKey;
    private static final char[] ALPHABET = new char[26];

    static {
        for (int i = 0; i < 26; i++) {
            ALPHABET[i] = (char) ('a' + i);
        }
    }


    RotationalCipher(int shiftKey) {
        if (shiftKey >=0 && shiftKey <=26) {
            this.shiftKey = shiftKey;
        }else System.out.println("invalid key");
    }

    String rotate(String data) {

        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                int rotatedIndex = Math.floorMod(index + shiftKey, ALPHABET.length);
                result.append(ALPHABET[rotatedIndex]);
            } else if (c >= 'A' && c <= 'Z') {
                int index = c - 'A';
                int rotatedIndex = Math.floorMod(index + shiftKey, ALPHABET.length);
                result.append(Character.toUpperCase(ALPHABET[rotatedIndex]));
            } else {
                result.append(c);
            }
        }return result.toString();
    }

}
