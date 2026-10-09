import java.util.ArrayList;
import java.util.List;

public class App2 {
    
    
    public static void main(String[] args) throws Exception {
        List<Integer> lista = new ArrayList<>();
        var t1 = new Thread(() -> {
            int i = 0;
            while(i < 10000){
                    synchronized (lista) {
                        if (lista.size() == 0 || lista.get(lista.size() - 1) == i - 1){
                            lista.add(i);
                            i+= 2;
                        }
                    }
                }
            });
        var t2 = new Thread(() -> {
            int i = 1;
             while(i < 10000){
                synchronized (lista) {
                    if (lista.size() > 0 && lista.get(lista.size() - 1) == i - 1){
                        lista.add(i);
                        i+= 2;
                    }
                    }
             }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final list size: " + lista.size());
        System.out.println("Final list value: " + java.util.Arrays.toString(lista.toArray()));
        
    }
}
