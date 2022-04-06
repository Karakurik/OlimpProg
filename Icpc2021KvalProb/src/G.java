import java.io.*;
import java.util.StringTokenizer;

public class G {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);

//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    private static void solve() {
        String[] arr;
        int n = nextInt();
        Integer l = null;
        Integer r = null;
        for (int i = 0; i < n; i++) {
            arr = nextLine().split(" ");
            switch (arr[0]) {
                case ">=" : {
                    if (arr[2].equals("Y")) {
                        if (l == null || Integer.parseInt(arr[1]) > l) {
                            l = Integer.parseInt(arr[1]);
                        }
                    } else {
                        if (r == null || Integer.parseInt(arr[1])-1 < r) {
                            r = Integer.parseInt(arr[1])-1;
                        }
                    }
                    break;
                }
                case ">" : {
                    if (arr[2].equals("Y")) {
                        if (l == null || Integer.parseInt(arr[1]) > l) {
                            l = Integer.parseInt(arr[1])-1;
                        }
                    } else {
                        if (r == null || Integer.parseInt(arr[1]) < r) {
                            r = Integer.parseInt(arr[1]);
                        }
                    }
                    break;
                }
                case "<" : {
                    if (arr[2].equals("N")) {
                        if (l == null || Integer.parseInt(arr[1]) > l) {
                            l = Integer.parseInt(arr[1]);
                        }
                    } else {
                        if (r == null || Integer.parseInt(arr[1])-1 < r) {
                            r = Integer.parseInt(arr[1])-1;
                        }
                    }
                    break;
                }
                case "<=" : {
                    if (arr[2].equals("N")) {
                        if (l == null || Integer.parseInt(arr[1])+1 > l) {
                            l = Integer.parseInt(arr[1])+1;
                        }
                    } else {
                        if (r == null || Integer.parseInt(arr[1]) < r) {
                            r = Integer.parseInt(arr[1]);
                        }
                    }
                    break;
                }
            }
        }
        if (l == null && r == null) {
            pw.println("Impossible");
        } else if (r == null) {
            pw.println(l);
        } else if(l == null) {
            pw.println(r);
        } else if (r>=l) {
            pw.println(r);
        } else {
            pw.println("Impossible");
        }
    }
}