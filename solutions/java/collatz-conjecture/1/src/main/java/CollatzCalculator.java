class CollatzCalculator {

    int computeStepCount(int start) {
        
        int steps = 0;

        if (start < 1){
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        
        while (start != 1){
            if(start % 2 == 0){
                start = start / 2;
            }else{
                start = (start * 3) + 1;
            }
            steps ++;
            }return steps;

        }
    }
