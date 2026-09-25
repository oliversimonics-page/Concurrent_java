public class App {
    public static void main(String[] args){
        var t1 = new Thread(new MyThread());
        var t2 = new Thread(new MyThread());
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } 
        catch (InterruptedException e) {
            return;
        }
        System.out.println("Kész");
    }
}
class MyThread extends Thread {
    @Override 
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
    }
}