package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Jialun Li on 30/11/2017
 */
public class SyncBlock {
    public List<Integer> list1 = new ArrayList<>();

    private Random random = new Random();

    private Object lock = new Object();

    public void work() {
        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
                list1.add(random.nextInt());
            }
        }
    }

    public static void main(String[] args) {

        SyncBlock syncBlock = new SyncBlock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncBlock.work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncBlock.work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(syncBlock.list1.size());

    }
}