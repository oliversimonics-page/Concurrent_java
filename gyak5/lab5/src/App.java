import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class App {

    private static final int CLIENT_COUNT = 100;
    private static final int LOANS_PER_CLIENT = 10_000;

    public static void main(String[] args) throws Exception {
        var pool = Executors.newFixedThreadPool(5);
        var bank = new Bank();
        var clientTotals = new long[CLIENT_COUNT];

        for (var client = 0; client < CLIENT_COUNT; client++) {
            var clientIndex = client;
            pool.submit(() -> {
                long clientTotal = 0;
                for (var round = 0; round < LOANS_PER_CLIENT; round++) {
                    var loan = ThreadLocalRandom.current().nextInt(100, 1000);
                    bank.addLoan(loan);
                    clientTotal += loan;
                }
                clientTotals[clientIndex] = clientTotal;
            });
            pool.submit(() -> {
                long clientTotal = 0;
                for (var round = 0; round < LOANS_PER_CLIENT; round++) {
                    var loan = ThreadLocalRandom.current().nextInt(100, 1000);
                    bank.addLoan(loan);
                    clientTotal += loan;
                }
                return clientTotal;
            });
        }

        pool.shutdown();
        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Várakozás az ügyfelek befejezésére...");
        }

        long clientTotalsSum = 0;
        for (var clientTotal : clientTotals) {
            clientTotalsSum += clientTotal;
        }

        var bankTotal = bank.egyenleg;
        System.out.println("Bank egyenlege: " + bankTotal);
        System.out.println("Ügyfélösszegek összege: " + clientTotalsSum);
        System.out.println("Az összegek megegyeznek: " + (clientTotalsSum == bankTotal));
    }
    
    // public static void main(String[] args) throws Exception {
    // var pool = Executors.newFixedThreadPool(10);

    // for (var i = 0; i < 50; i++) {
    // pool.execute(() -> {
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // return;
    // }
    // IO.println("hello");
    // });
    // }

    // pool.shutdown();
    // while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
    // IO.println("===== waiting ====");
    // }
    // }
}
