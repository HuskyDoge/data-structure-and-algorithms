package general;

/**
 * @author Jialun Li on 25/09/2018
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start thread");
        for (int i = 0; i < 5; i++) {
            System.out.println("i=" + i + " ,ThreadName=" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
