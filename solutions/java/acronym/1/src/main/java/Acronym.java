class Acronym {

    private String phrase;
    
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        String cleanedPhrase = phrase.replace("_", "");
        String acronym = "";        
        String[] words = cleanedPhrase.split("[\\s-]+");;
        for (String word : words){
            acronym += word.charAt(0);            
        }
        return acronym.toUpperCase();
        
    }

}
