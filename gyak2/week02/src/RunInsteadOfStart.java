public class RunInsteadOfStart {
    public static void main(String[] args) {
        Thread hello = new Thread(() -> printText("Hello"));
        Thread world = new Thread(() -> printText("world"));

        hello.run();
        world.run();
    }

    private static void printText(String text) {
        for (int repeat = 0; repeat < 10000; repeat++) {
            System.out.println(text);
        }
    }
}
