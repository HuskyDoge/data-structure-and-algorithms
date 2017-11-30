package designmode.immutableobject;

/**
 * @author Jialun Li on 30/11/2017
 */
public class SynchronizedRGBTest {
    public static void main(String[] args) {
        SynchronizedRGB synchronizedRGB = new SynchronizedRGB(5,5,5, "five hero");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (synchronizedRGB) {
                    int myColorInt = synchronizedRGB.getRGB();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String myColorName = synchronizedRGB.getName();
                    System.out.println(myColorInt + " " + myColorName);
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedRGB.set(6,6,6,"six hero");
            }
        });

        thread.start();
        thread1.start();
    }

}
