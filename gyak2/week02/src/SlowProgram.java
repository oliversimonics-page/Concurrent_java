public class SlowProgram {
  public static void main(String[] args) throws InterruptedException {
        
        Runnable task = () -> {
            long sum = 0;
            for(int i=1; i <= 1_000_000_000; i++){
                sum+=i;
            }
            System.out.println(sum);
            
        };

        // 2. A ThreadGroup átadása első paraméterként a konstruktornak
        Thread one = new Thread(task);

        long st = System.nanoTime();
        one.start();
        one.join();
        
        long en = System.nanoTime();
        long time = en-st;
        System.out.println(time/1_000_000.0);

    }  
}
