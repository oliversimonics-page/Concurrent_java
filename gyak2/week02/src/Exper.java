public class Exper {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread();
        Thread world = new Thread();
        hello.setName("Hello");
        world.setName("World");
        var group = new ThreadGroup();
        hello.start();
        world.start();

        hello.join();
        world.join();
    }

    private  class TextRunnable implements Runnable {
        String name;
        private TextRunnable() {
            this.name = "";
        }

        @Override
        public void run() {
            
        }
        public void setName(String name){
            this.name = name;
        }
    }

}
