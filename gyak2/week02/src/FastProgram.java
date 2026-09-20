public class FastProgram {
    private static long sum = 0;
    public static void main(String[] args) throws InterruptedException {
        
        

        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            int i1 = i;
            Runnable task = () -> {
                long local = 0;
                for(int j=i1*100_000_000+1; j <= i1*100_000_000+100_000_000; j++){
                    local += j;
                }
                synchronized (FastProgram.class) {
                    sum += local;
                }
            };
            
            threads[i] = new Thread(task);
        }
        

        long st = System.nanoTime();
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        
        long en = System.nanoTime();
        long time = en-st;
        System.out.println(time/1_000_000.0);

    }  
}
