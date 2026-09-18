import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        var t = new MyThread();
        var t2 = new Thread(new MyRunnable());

        var t3 = new Thread(()-> {
            IO.println("Hello lambda");
        });
        
        t.start();
        t2.start();
        t3.start();


        t.join();
        t2.join();
        t3.join();

        var pw = new PrintWriter("x.txt");
        pw.println("sajt");
        pw.close();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        IO.println("Hello");
    }
}
class MyRunnable implements Runnable{
    @Override 
    public void run(){
        IO.println("Hello szia");
    }
}