import java.util.List;
import java.util.ArrayList;
    
class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        
        int multiplier = 10;
        List<Integer> numbers = new ArrayList<>();
        int sumOfMults = 0;        
       
        
        for (char c : stringToVerify.toCharArray()) {
            if (Character.isDigit(c)) {
            numbers.add(Character.getNumericValue(c));
            }else if (c == 'X'){
                if (numbers.size() == 9){
                numbers.add(10);
                }else return false;    
            }else if (c == '-'){
            continue;        
            }else 
                return false;
        }
        
        if (numbers.size() == 10){        
            for (int i : numbers){
            sumOfMults += i * multiplier;
            multiplier -= 1;
            }
            if (sumOfMults % 11 == 0){
                return true;
            }else return false;
    }else 
            return false;

}
}
