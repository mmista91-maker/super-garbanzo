import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class LargestSeriesProductCalculator {

    private String inputNumber;
    
    LargestSeriesProductCalculator(String inputNumber) {
    
        this.inputNumber = inputNumber;
    
        if (!inputNumber.chars()
            .allMatch(c -> Character.isDigit(c))) {            
        throw new IllegalArgumentException(
            "String to search may only contain digits."
    );
    }    
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {       
        
    if (numberOfDigits > inputNumber.length()) {
        throw new IllegalArgumentException(
            "Series length must be less than or equal to the length of the string to search."
        );
    }
        List<Long> products = new ArrayList<>();
        
        for (int i = 0; i + numberOfDigits <= inputNumber.length(); i++) {
        String series = inputNumber.substring(i, i + numberOfDigits);
            long product = 1;
            for (char c : series.toCharArray()){
            product *= Character.getNumericValue(c);            
            }
            products.add(product);
    }
        return Collections.max(products);
}
}
    
