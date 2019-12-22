/* Example usage:
 *
 * FastIO io = new FastIO(System.in, System.out);
 *
 * while (io.hasNext()) {
 *    int n = io.nextInt();
 *    double d = io.nextDouble();
 *    double ans = d*n;
 *
 *    io.println("Answer: " + ans);
 * }
 *
 * io.flush();   // DON'T FORGET THIS LINE!
 */

import java.util.*;
import java.io.*;

class FastIO extends PrintWriter {
    public FastIO(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public FastIO(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public boolean hasNext() { return peekToken() != null; }
    public int nextInt() { return Integer.parseInt(nextToken()); }
    public double nextDouble() { return Double.parseDouble(nextToken()); }
    public long nextLong() { return Long.parseLong(nextToken()); }
    public String next() { return nextToken(); }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
