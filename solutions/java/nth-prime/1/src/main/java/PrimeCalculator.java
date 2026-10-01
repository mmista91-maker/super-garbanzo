class PrimeCalculator {

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }    
        int counter = 0;
        int toCheck = 2;    
        while (nth > counter) {
            if (isPrime(toCheck)) {
                counter++;
            }
            toCheck++;
        }    
        return toCheck - 1;
    }
    
    private boolean isPrime(int number) {    
        if (number < 2) {
            return false;
        }    
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }    
        return true;
}
}
