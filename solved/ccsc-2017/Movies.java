import java.util.Scanner;

public class Movies {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++){
            int movies = scan.nextInt();
            int length = scan.nextInt();
            int[] array = new int[movies];
            for(int i = 0; i < movies; i++){
                array[i] = scan.nextInt();
            }
            System.out.println(solve(array, length));
        }
    }

    public static int solve(int[] movies, int target){
        int total = 0;
        for(int i = 0; i <  Math.pow(2,movies.length); i++){
            int sum = 0;
            for (int j = 0; j < movies.length; j++){
                if ((i & (1 << j)) > 0){
                    sum += movies[j];
                }
            }
            if (sum == target){
                total++;
            }
        }

        return total;
    }

}
