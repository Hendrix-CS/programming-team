import java.io.*;
import java.util.*;
import java.math.*;
import java.security.*;

public class AnnotateMD5 {
    public static String md5Sig(String s) {
        try {
            byte[] bs = MessageDigest.getInstance("MD5").digest(s.getBytes());
            return String.format("%02x", bs[0]);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
    public static void main(String args[]) {
        String file = "";
        if (args.length > 0) file = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("File to annotate: ");
            file = in.nextLine();
        }
        try {
            Scanner f = new Scanner(new File(file));
            while (f.hasNext()) {
                String line = f.nextLine();
                String sig = md5Sig(line.replaceAll("\\s", ""));
                System.out.print(line);
                for (int i = line.length(); i < 80; i++) System.out.print(" ");
                System.out.println(" // " + sig);
            }
        } catch (FileNotFoundException e) { System.out.println(e); }
    }
}
