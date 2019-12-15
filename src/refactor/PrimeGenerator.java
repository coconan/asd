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

    private static boolean[] crossedOut;
    private static int[] result;

    /**
     * @param maxValue is the generation limit.
     */
    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegerIntoResult();
            return result;   // return the primes`
        }
    }

    private static void putUncrossedIntegerIntoResult() {
        result = new int[numberOfUncrossedIntegers()];

        // move the primes into the result
        for (int i = 2, j = 0; i < crossedOut.length; i++) {
            if (notCrossed(i)) {    // if prime
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
        }
        return count;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++) {
            if (notCrossed(i)) {  // if i is uncrossed, cross out its multiples.
                crossOutMultiplesOf(i);
            }
        }
    }

    private static int determineIterationLimit() {
        // Every multiple in the array has a prime factor that
        // is less than or equal to the root of the array size,
        // so we don't have to cross of multiples of numbers
        // larger than that root.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i) {
            crossedOut[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return !crossedOut[i];
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }
}
