class LuhnValidator {

    boolean isValid(String candidate) {
        
        String digits = candidate.replace(" ", "");       
        if (digits.length() < 2) {
            return false;
        }        
        if (!digits.chars()
                .allMatch(c -> Character.isDigit(c))) {
            return false;
        }
        int sum = 0;
        boolean doubleDigit = false;
       
        for (int i = digits.length() - 1; i >= 0; i--) {
            int digit = digits.charAt(i) - '0';
            if (doubleDigit) {
                digit *= 2;

                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;           
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}