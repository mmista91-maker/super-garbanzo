class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = 0;         
        for (int num = 1; num <= input; num++) {
        sum += num;
        }      
        return  sum*sum;   
        }

    int computeSumOfSquaresTo(int input) {
        int sum = 0;
        for (int num = 1; num <= input; num++) {
        sum += num*num;
    }
        return sum;
    }   
    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
