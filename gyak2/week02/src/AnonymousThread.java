public class AnonymousThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread("Hello") {
            @Override
            public void run() {
                printText(getName());
            }
        };

        Thread world = new Thread("world") {
            @Override
            public void run() {
                printText(getName());
            }
        };

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
