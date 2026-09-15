public class PangramChecker {

    public boolean isPangram(String input) {
        String inputlower = input.toLowerCase();
        for (char letter = 'a'; letter <= 'z'; letter++) {
        if (! inputlower.contains(String.valueOf(letter))) {
        return false;
    }
}

    return true;    

}
}