import java.util.ArrayList;
import java.util.List;

public class App3 {
    public static void main(String[] args) throws Exception {
        List<Integer> lista = new ArrayList<>();
        
        var t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i += 2) {
                synchronized (lista) {
                    while (lista.size() > 0 && lista.get(lista.size() - 1) != i - 1) {
                        try {
                            lista.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    lista.add(i);
                    lista.notifyAll();
                }
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 1; i < 10000; i += 2) {
                synchronized (lista) {
                    while (lista.size() == 0 || lista.get(lista.size() - 1) != i - 1) {
                        try {
                            lista.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    lista.add(i);
                    lista.notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("Final list size: " + lista.size());
        System.out.println("Final list value (first 10): " + lista.subList(0,  lista.size()));
    }
}