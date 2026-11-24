class Proverb {

    String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder answer = new StringBuilder();
        if (words.length >= 2 ){
            for (int i = 0; i < words.length - 1; i++){
                answer.append("For want of a ")
                      .append(words[i])
                      .append(" the ")
                      .append(words[i + 1])
                      .append(" was lost.")
                      .append('\n');
            }
            answer.append("And all for the want of a ")
                    .append(words[0])
                    .append('.');
            return answer.toString();
        }
        else if(words.length == 1){
            String ending = String.format("And all for the want of a %s.", words[0]);
            return ending;
        }
        return "";
    }

}
