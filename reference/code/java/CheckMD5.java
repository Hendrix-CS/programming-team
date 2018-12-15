import java.io.*;
import java.util.*;
import java.math.*;
import java.security.*;

public class CheckMD5 {

    public static String md5Sig(String input) {
        try {
            byte[] bs = MessageDigest.getInstance("MD5").digest(input.getBytes());
            return String.format("%02x", bs[0]);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("File to annotate: ");
        String file = in.nextLine();

        try {
            Scanner f = new Scanner(new File(file));
            while (f.hasNext()) {
                String line = f.nextLine();
                String sig = md5Sig(line.replaceAll("\\s", ""));
                System.out.println((line.equals("") ? "  " : sig) + " " + line);
            }
        } catch (FileNotFoundException e) { System.out.println(e); }
    }
}
