package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jialun Li on 30/11/2017
 */
public class SimpleThreadPool implements Runnable {
    private boolean runStatus = true;

    @Override
    public void run() {
        System.out.println("haha");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println("task interrupted!!");
//        }
        while (runStatus) {
            if (Thread.interrupted()) {
                System.out.println("runStatus: " + runStatus);
                System.out.println("while loop interrupt");
                shutdown();
                System.out.println("runStatus: " + runStatus);
            }
        }

    }

    public void shutdown() {
        runStatus = false;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 8; i++) {
            executorService.submit(new SimpleThreadPool());
        }

        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("waited for 10 sec already");
        }
    }
}
