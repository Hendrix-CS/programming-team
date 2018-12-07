import java.util.*;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // All these read a single token (ignore leading whitespace,
        // then read up until but not including the next whitespace)
        String s = in.next();
        int    n = in.nextInt();
        long   l = in.nextLong();
        double d = in.nextDouble();

        // WARNING!! A previous call to nextXXX will read up to a
        // newline character but leave it unconsumed in the input, so
        // the next call to nextLine() will just read that newline and
        // return an empty string!
        in.nextLine();   // throw away the empty line to get ready for the next

        // Read a whole line up to the next newline character.
        // Consumes the newline but does not include it in the
        // returned String.
        String line = in.nextLine();

        // Read until end of input
        while (in.hasNext()) {
            line = in.nextLine();
        }
    }
}
