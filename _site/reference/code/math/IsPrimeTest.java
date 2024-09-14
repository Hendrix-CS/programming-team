public class IsPrimeTest {
    public static void main(String[] args) {
        int count = 0;
        int MIN = 1000000000;
        int MAX = MIN + 100000;
        for (int i = MIN; i < MAX; i++) {
            if (IsPrime.isPrime(i)) count++;
        }

        System.out.println(count + " primes between " + MIN + " and " + MAX);

        // Output:
        // 4832 primes between 1000000000 and 1000100000

        // Confirmed correct with
        // https://www.wolframalpha.com/input/?i=number+of+primes+between+10%5E9+and+10%5E9+%2B+10%5E5
    }
}
