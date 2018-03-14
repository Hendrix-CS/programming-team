import java.math.BigInteger;
import java.util.Scanner;

public class WorldTraveler2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        for (int t = 0; t < numTests; t++) {
            int numCities = scan.nextInt();
            int totalDays = 0;
            BigInteger product = BigInteger.ONE;
            scan.nextLine();
            for (int n = 0; n < numCities; n++) {
                String[] line = scan.nextLine().split(" ");
                char days = line[line.length - 1].charAt(0);
                int numDays = 0;
                if (days >= '2' && days <= '7') {
                    numDays = Integer.parseInt(String.valueOf(days));
                } else {
                    numDays = 1;
                }
                product = product.multiply(factorial(numDays));
                totalDays += numDays;
            }
            BigInteger result = factorial(totalDays).divide(product);
            System.out.println(result);
        }

    }

    public static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
