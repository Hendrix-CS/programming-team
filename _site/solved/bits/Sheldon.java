import java.util.*;

public class Sheldon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long X = in.nextLong();
        long Y = in.nextLong();

        int count = 0;
        long sheldon;
        for (int n = 1; n <= 63; n++) {
            for (int i = 1; i <= n; i++) {
                if (i == n) {
                    sheldon = (1L << n) - 1;
                    if (X <= sheldon && sheldon <= Y) count++;
                } else {
                    for (int j = 1; j <= n-i; j++) {
                        if (n % (i+j) == 0 || n % (i+j) == i) {
                            sheldon = mkSheldon(n,i,j);
                            if (X <= sheldon && sheldon <= Y) count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static long mkSheldon(int n, int i, int j) {
        long result = 0;
        result = (1L << i) - 1;
        int nbits = i;

        while (nbits < n) {
            result = result << j;
            nbits += j;

            if (nbits < n) {
                result = (result << i) + ((1L << i) - 1);
                nbits += i;
            }
        }

        return result;
    }
}

// class SN implements Comparable<SN> {
//     public int n, i, j;

//     public SN(long num) {
//         String bits = Long.toBinaryString(num);

//         n = bits.length();

//         int index = 0;
//         while (index < n && bits.charAt(index) == '1') {
//             i++;
//             index++;
//         }
//         while (index < n && bits.charAt(index) == '0') {
//             j++;
//             index++;
//         }

//         next();
//     }

//     public SN(int n, int i, int j) {
//         this.i = i;
//         this.j = j;
//         this.n = n;
//     }

//     public long toLong() {
//     }

//     public int compareTo(SN other) {
//         if (n != other.n) {
//             return n - other.n;
//         } else if (i != other.i) {
//             return i - other.i;
//         } else {
//             return other.j - j;
//         }
//     }

//     public void next() {
//         rawNext();
//         while (!valid()) {
//             rawNext();
//         }
//     }

//     private void rawNext() {
//         if ( i == n ) {
//             n++;
//             i = 1;
//             j = n-1;
//         } else if ( j == 1 ) {
//             i++;
//             j = n-i;
//         } else {
//             j--;
//         }
//     }

//     public boolean valid() {
//         return (i == n) || (n % (i+j) == 0) || (n % (i+j) == i);
//     }

//     public String toBits() {
//         String bits = "";
//         while (bits.length() < n) {
//             for (int k = 0; k < i; k++) {
//                 bits += "1";
//             }
//             if (bits.length() < n) {
//                 for (int k = 0; k < j; k++) {
//                     bits += "0";
//                 }
//             }
//         }
//         return bits;
//     }

//     public String toString() {
//         return "<" + n + ", " + i + ", " + j + "> = " + toLong() + " = " + toBits();
//     }

// }
