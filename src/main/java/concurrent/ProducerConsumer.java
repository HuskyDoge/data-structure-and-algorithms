package concurrent;


import java.util.Scanner;

/**
 * @author Jialun Li on 30/11/2017
 */
public class ProducerConsumer {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("produce started: ");
            wait();
            System.out.println("returned: ");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            System.out.println("consume started: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("wait for next return key: ");
            scanner.nextLine();
            notify();
            Thread.sleep(5000);
            System.out.println("slept 5000 ms");
        }
    }


    public static void main(String[] args) {
        ProducerConsumer app = new ProducerConsumer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    app.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    app.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
