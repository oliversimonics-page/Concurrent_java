public class RunnableClass {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(new TextRunnable("Hello"));
        Thread world = new Thread(new TextRunnable("world"));

        hello.start();
        world.start();

        hello.join();
        world.join();
    }

    private static class TextRunnable implements Runnable {
        private final String text;

        private TextRunnable(String text) {
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
