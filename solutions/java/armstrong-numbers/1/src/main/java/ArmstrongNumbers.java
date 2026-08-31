class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
     String number = String.valueOf(numberToCheck);
        int powerSum = 0;
        int exponent = number.length();
    
        for (char digitCharacter : number.toCharArray()){
            int digit = Character.getNumericValue(digitCharacter);
            powerSum += (int) Math.pow(digit, exponent);  
        }
        return powerSum == numberToCheck;      

    }

}
