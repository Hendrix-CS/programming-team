import java.util.Scanner;

public class sumOfTheOthers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] s = in.nextLine().split(" ");
            int out = 0;
            for (String i : s) {
                out += Integer.parseInt(i);
            }
            System.out.println(out / 2);
        }
        in.close();
    }
}
