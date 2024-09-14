import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Colors {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/colors.in"));
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++){
            int rows = scan.nextInt();
            int columns = scan.nextInt();
            scan.nextLine();
            int[][] outputArray = new int[rows][columns];
            for(int r = 0; r < rows; r++){
                String line = scan.nextLine();
                String[] splits = line.split(" ");
                for(int c = 0; c < splits.length; c++){
                    String s = splits[c];
                    String result = s.replace("(","");
                    result = result.replace(")", "");
                    String[] nums  = result.split(",");
                    int r1 = Integer.parseInt(nums[0]);
                    int g = Integer.parseInt(nums[1]);
                    int b = Integer.parseInt(nums[2]);
                    outputArray[r][c] = average(r1, g, b);
                    System.out.print(outputArray[r][c]);
                    System.out.print(" ");

                }
                System.out.println();
            }
        }

    }

    public static int average(int r, int g, int b){
        int max = Math.max(r, Math.max(g,b));
        int min = Math.min(r, Math.min(g,b));
        return (max + min) / 2;
    }

}
