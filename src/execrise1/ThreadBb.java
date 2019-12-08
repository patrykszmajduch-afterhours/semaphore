package execrise1;

import java.util.concurrent.Semaphore;

public class ThreadBb extends Thread {
    Semaphore semA,semB;

    public ThreadBb(Semaphore semA, Semaphore semB) {
        this.semA = semA;
        this.semB = semB;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("END OF B");
                break;
            }
            try {
                semB.acquire();
                System.out.println("THREAD B!!###################################");

            } catch (InterruptedException e) {//interruptedException kasuje flage?
                System.out.println(e);
                break;
            }
            finally {
                semA.release();
            }
        }
    }

}
