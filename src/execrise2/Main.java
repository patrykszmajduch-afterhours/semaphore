package execrise2;



import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       test1();

    }


    static void test1()
    {
        Semaphore sem = new Semaphore(0,true);

        Thread t1 = new ThreadA(sem);
        Thread t2 = new ThreadB(sem);
        t1.start();
        t2.start();
        sem.release(1);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }


}
