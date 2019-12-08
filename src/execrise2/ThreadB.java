package execrise2;

import java.util.concurrent.Semaphore;

public class ThreadB extends Thread {
    Semaphore sem;

    public ThreadB(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        while (true) {
            while (!sem.tryAcquire()) {//jak ze zuzyciem zasobow???
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("END OF LOOP in B");
                    break;
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("END OF B");
                break;
            }
            System.out.println("THREAD B WORKING!!!!");
            sem.release();
        }
    }

}
