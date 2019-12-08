package execrise1;

import java.util.concurrent.Semaphore;

public class ThreadB extends Thread {
    Semaphore sem;

    public ThreadB(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("END OF B");
                break;
            }
            try {
                sem.acquire();
                System.out.println("THREAD B!!###################################");

            } catch (InterruptedException e) {//interruptedException kasuje flage?
                e.printStackTrace();
                break;
            }
            finally {
                sem.release();
            }
        }
    }

}
