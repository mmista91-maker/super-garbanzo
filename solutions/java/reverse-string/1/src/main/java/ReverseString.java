class ReverseString {

    String reverse(String inputString) {
        
        
        String s = inputString;
        String r = "";

        for (int i = 0; i < inputString.length(); i++){            
           
            r = s.charAt(i) + r; 
        }
        return r;
    }
}
