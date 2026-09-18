public class CharacterPrint {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(() -> printCharacters("Hello"));
        Thread world = new Thread(() -> printCharacters("world"));

        hello.start();
        world.start();

        hello.join();
        world.join();
    }

    private static void printCharacters(String text) {
        for (int repeat = 0; repeat < 10000; repeat++) {
            for (int index = 0; index < text.length(); index++) {
                System.out.print(text.charAt(index));
            }
        }
    }
}
