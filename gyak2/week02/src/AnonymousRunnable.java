public class AnonymousRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable helloTask = new Runnable() {
            @Override
            public void run() {
                printText("Hello");
            }
        };

        Runnable worldTask = new Runnable() {
            @Override
            public void run() {
                printText("world");
            }
        };

        Thread hello = new Thread(helloTask);
        Thread world = new Thread(worldTask);

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
