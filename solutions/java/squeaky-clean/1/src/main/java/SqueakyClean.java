class SqueakyClean {

    static String clean(String identifier) {        
        StringBuilder builder = new StringBuilder();
        boolean isAfterDash = false;
        
        for (char rawChar : identifier.toCharArray()) {
            char c = replaceLeet(rawChar);
            
            if (c == '-') {
                isAfterDash = true;
            } else if (Character.isWhitespace(c)) {
                builder.append('_');
                isAfterDash = false;
            } else if (Character.isLetter(c)) {
                if (isAfterDash) {
                    builder.append(Character.toUpperCase(c));
                    isAfterDash = false; 
                } else {
                    builder.append(c);
                }
            }
        }
        
        return builder.toString();
    }

    private static char replaceLeet(char c) {
        return switch (c) {
            case '4' -> 'a';
            case '3' -> 'e';
            case '0' -> 'o';
            case '1' -> 'l';
            case '7' -> 't';
            default  -> c;
        };
    }
}