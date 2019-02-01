/**
 * @author Jialun Li on 25/09/2018
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("In main() method");
        MyRunnable runnable=new MyRunnable();
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);

        thread1.start();
        thread1.join(3000);

        thread2.start();
        thread2.join();

        thread1.run();

        thread1.start();
        System.out.println("end main() method");
    }
}
