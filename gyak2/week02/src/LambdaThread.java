public class LambdaThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(() -> printText("Hello"));
        Thread world = new Thread(() -> printText("world"));

        hello.start();
        world.start();

        hello.join();
        world.join();
    }

    private static void printText(String text) {
        for (int repeat = 0; repeat < 10000; repeat++) {
            System.out.println(text);
        }
    }
}
