class NaturalNumber {

    int numbertocheck;
    
    NaturalNumber(int number) {
        
        if (number > 0){
            numbertocheck = number;
        }else{
        throw new IllegalArgumentException (
            "You must supply a natural number (positive integer)"
        );
            }
    }

    Classification getClassification() {

        int sum = 0;
        for (int i = 1; i < numbertocheck; i++ ){           
        if (numbertocheck % i == 0){
            sum += i;
        }
        }
    if (sum == numbertocheck) return Classification.PERFECT;
    else if (sum > numbertocheck) return Classification.ABUNDANT;
    else return Classification.DEFICIENT;        
    }
}
