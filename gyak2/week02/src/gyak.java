
public class gyak {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("Hello");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("world");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();



    }
    }


    class MyThread extends Thread{
        String a;
    public MyThread(String a){
        super();
        this.a = a;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
                System.out.println(this.a);
            }
        }
    }
