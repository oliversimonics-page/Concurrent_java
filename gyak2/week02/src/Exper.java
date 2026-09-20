import java.lang.ThreadGroup;
public class Exper {
    public static void main(String[] args) throws InterruptedException {
        var group = new ThreadGroup("Mygroup");
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 2. A ThreadGroup átadása első paraméterként a konstruktornak
        Thread hello = new Thread(group, task);
        Thread world = new Thread(group, task);

        hello.setName("Hello");
        world.setName("World");

        hello.start();
        world.start();

        group.activeCount();
        group.list();

        hello.join();
        world.join();
    }

}
