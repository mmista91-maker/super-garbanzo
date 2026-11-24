class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words == null || words.length == 0) {
            return "";
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            answer.append("For want of a ")
                    .append(words[i])
                    .append(" the ")
                    .append(words[i + 1])
                    .append(" was lost.")
                    .append('\n');
        }

        answer.append("And all for the want of a %s.".formatted(words[0]));
        return answer.toString();
    }

}