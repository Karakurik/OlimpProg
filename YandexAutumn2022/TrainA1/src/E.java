import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int[] arr = new int[26];
        try {
            for (char c : br.readLine().toCharArray()) {
                arr[c - 'a']++;
            }
            for (char c : br.readLine().toCharArray()) {
                arr[c - 'a']--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                pw.println(0);
                pw.close();
                return;
            }
        }
        pw.println(1);
        pw.close();
    }
}
