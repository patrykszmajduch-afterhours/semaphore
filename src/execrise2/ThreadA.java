package execrise2;

import java.util.concurrent.Semaphore;

public class ThreadA extends Thread {
    Semaphore sem;

    public ThreadA(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        while (true) {

            while (!sem.tryAcquire()) {//jak ze zuzyciem zasobow???
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("END OF LOOP in A");
                    break;
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("END OF A");
                break;
            }
            System.out.println("THREAD A WORKING!!!!");
            sem.release();
        }
    }
}
