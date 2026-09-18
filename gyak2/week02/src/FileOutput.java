import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutput {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            Thread hello = new Thread(() -> printText(writer, "Hello"));
            Thread world = new Thread(() -> printText(writer, "world"));

            hello.start();
            world.start();

            hello.join();
            world.join();
        }
    }

    private static void printText(PrintWriter writer, String text) {
        for (int repeat = 0; repeat < 10000; repeat++) {
            synchronized (writer) {
                writer.println(text);
            }
        }
    }
}
