package problemsfrombooks.epi.ch06arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOfflineData {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        int k = 5;
        Arrays.asList(a);
        List<Integer> result = f(Arrays.asList(a), k);
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static List<Integer> f(List<Integer> a, int k) {
        Random r = new Random();

        if (k <= a.size() && k > 0) {
            for (int i = 0; i < k; i++) {
                //Returns a pseudorandom, uniformly distributed {@code int} value
                //between 0 (inclusive) and the specified value (exclusive),
                int randomIndex = r.nextInt(a.size() - i);
                int index = randomIndex + i;
                Collections.swap(a, index, i);
            }
        }
        return a;
    }

}
