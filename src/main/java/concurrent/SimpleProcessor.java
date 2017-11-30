package concurrent;

/**
 * @author Jialun Li on 30/11/2017
 */
public class SimpleProcessor implements Runnable {

    public void run() {
        while (true) {
            System.out.println("I am busy");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrupted! ");
                e.printStackTrace();
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleProcessor simpleProcessor = new SimpleProcessor();
        Thread thread = new Thread(simpleProcessor);
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
    }
}
