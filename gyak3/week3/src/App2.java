import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new MyThread2("Thread-" + i);
            threads[i].start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println("A sleep után:");
        for (Thread thread : threads) {
            System.out.println(thread.getName() + ": " + readLastLine(thread.getName() + ".txt"));
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("A join után:");
        for (Thread thread : threads) {
            System.out.println(thread.getName() + ": " + readLastLine(thread.getName() + ".txt"));
        }
    }

    private static String readLastLine(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            if (lines.isEmpty()) {
                return "üres";
            }
            return lines.get(lines.size() - 1);
        } catch (IOException e) {
            return "nincs fájl";
        }
    }
}

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        String fileName = getName() + ".txt";
        for (int i = 1; i <= 10_000; i++) {
            try (PrintWriter pr = new PrintWriter(fileName)) {
                pr.println(i);
            } catch (FileNotFoundException e) {
            }
        }
    }
}