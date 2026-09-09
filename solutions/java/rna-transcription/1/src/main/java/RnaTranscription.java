class RnaTranscription {


    String transcribe(String dnaStrand) {
        
        String translated = "";
            
        for (int i = 0; i < dnaStrand.length(); i++) {       
            
            
        switch (dnaStrand.charAt(i)){
           case 'G':
               translated += 'C';
               break;
           case 'C':
               translated += 'G';
               break;
           case 'T':
               translated += 'A';
               break;
           case 'A':
               translated += 'U';
               break;
           default:
              break;             
       };
    }
        return translated;  
    }

}
