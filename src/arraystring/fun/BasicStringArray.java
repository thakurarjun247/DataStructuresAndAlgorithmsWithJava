package arraystring.fun;

public class BasicStringArray {
    // removes a given character c from a given string s, sequentially
    public String remove(String s, char c) {
        char[] array = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != c) {
                builder.append(array[i]);
            }
        }
        return builder.toString();
    }

    //returns boolean value after checking if a given number n is prime
    // A prime number is a whole number greater than 1, whose only two whole-number
    // factors are 1 and itself. The first few prime numbers are 2, 3, 5, 7, 11, 13,
    // 17, 19, 23, and 29. As we proceed in the set of natural numbers N = {1, 2, 3,
    // ...}, the primes become less and less frequent in general.
    public boolean isPrime(int n) {
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) {
            if (n % i == 0) {
                System.out.println("divisible by " + i);
                return false;
            }
        }
        return true;
    }

}
