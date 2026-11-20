class Bob {

    String hey(String input) {
        if (input.endsWith("?") && isYelling(input)){
            return "Calm down, I know what I'm doing!";
        } else if (input.strip().endsWith("?")) {
            return "Sure.";
        } else if (isYelling(input)) {
            return "Whoa, chill out!";
        } else if (input.isBlank()) {
            return "Fine. Be that way!";
        }
        return "Whatever.";
    }
    private boolean isYelling(String text) {
        boolean hasLetter = text.chars().anyMatch(Character::isLetter);
        return hasLetter && text.equals(text.toUpperCase());
    }

}