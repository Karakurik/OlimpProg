import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("test.txt");
        pw.println("1000 10");
        for (int i = 1000; i >= 1; i--) {
            pw.print(i + " ");
        }
    }
}
