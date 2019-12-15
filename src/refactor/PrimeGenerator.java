package refactor;

/**
 * This class Generates prime numbers up to a user specified maximum.
 * the algorithm used is the Sieve of Eratosthenes.
 * Given an array of integers starting at 2:
 * Find the first uncrossed integer, and cross out all of its
 * multiples. Repeat until there are no more multiples
 * in the array.
 *
 * @author Robert C. Martin
 * @version 8 Dec 1999 rcm
 */
public class PrimeGenerator {

    private static boolean[] f;
    private static int[] result;

    /**
     * @param maxValue is the generation limit.
     */
    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegerIntoResult();
            return result;   // return the primes`
        }
    }

    private static void putUncrossedIntegerIntoResult() {
        int i;
        int j;

        // how many primes are there?
        int count = 0;
        for (i = 0; i < f.length; i++) {
            if (f[i]) {
                count++;   // bump count
            }
        }

        result = new int[count];

        // move the primes into the result
        for (i = 0, j = 0; i < f.length; i++) {
            if (f[i]) {    // if prime
                result[j++] = i;
            }
        }
    }

    private static void crossOutMultiples() {
        int i;
        int j;

        for (i = 2; i < Math.sqrt(f.length) + 1; i++) {
            if (f[i]) {  // if i is uncrossed, cross out its multiples.
                for (j = 2 * i; j < f.length; j+=i) {
                    f[j] = false;   // multiple is not prime
                }
            }
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        // declarations
        f = new boolean[maxValue + 1];
        f[0] = f[1] = false;
        int i;
        // initialize array to true.
        for (i = 2; i < f.length; i++) {
            f[i] = true;
        }
    }
}
