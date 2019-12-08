package execrise1;

import java.util.concurrent.Semaphore;

public class ThreadA extends Thread {
    Semaphore sem;

    public ThreadA (Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("END OF A");
                break;
            }
            try {
                sem.acquire();
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@THREAD A!!");
                //notifyAll(); to może być tylko poza watkiem którego się odnosi?
               // wait();
            } catch (InterruptedException e) {
                System.out.println(e);
                break;

            }
            finally {
                sem.release();
            }
        }
    }
}
