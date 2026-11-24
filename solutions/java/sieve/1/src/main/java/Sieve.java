import java.util.ArrayList;
import java.util.List;

class Sieve {

    int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime=maxPrime;
    }

    List<Integer> getPrimes() {

        if (maxPrime < 2) {
            return List.of();
        }

        boolean[] isComposite = new boolean[maxPrime+1];

        for (int p = 2; (long) p * p <= maxPrime; p++) {
            if (!isComposite[p]) {
                for (long multiple = (long) p * p; multiple <= maxPrime; multiple += p) {
                    isComposite[(int) multiple] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxPrime; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }
        return primes;


    }
}
