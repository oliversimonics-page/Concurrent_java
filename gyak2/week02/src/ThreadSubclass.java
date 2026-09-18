public class ThreadSubclass {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new TextThread("Hello");
        Thread world = new TextThread("world");

        hello.start();
        world.start();

        hello.join();
        world.join();
    }

    private static class TextThread extends Thread {
        private final String text;

        private TextThread(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            printText(text);
        }
    }

    private static void printText(String text) {
        for (int repeat = 0; repeat < 10000; repeat++) {
            System.out.println(text);
        }
    }
}
