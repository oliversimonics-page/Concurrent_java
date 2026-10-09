public class App {
    static int counter = 0;
    static synchronized void add(int amount) {
        counter += amount;
    }
    public static void main(String[] args) throws Exception {
        var t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                add(1);
            }
        });
        var t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                add(-1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final counter value: " + counter);
    }
}
