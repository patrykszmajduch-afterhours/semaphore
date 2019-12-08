package execrise1;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       //test1();
       test2();
    }


    static void test1()
    {
        Semaphore sem = new Semaphore(1,true);
        sem.drainPermits();
        Thread t1 = new ThreadA(sem);
        Thread t2 = new  ThreadB(sem);

        t2.start();t1.start();
        sem.release();
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }
    static void test2()
    {

        Semaphore semA = new Semaphore(1);
        Semaphore semB = new Semaphore(0);
        Thread t1 = new ThreadAa(semA ,semB);
        Thread t2 = new ThreadBb(semA ,semB);

        t1.start();
        t2.start();
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }

}
