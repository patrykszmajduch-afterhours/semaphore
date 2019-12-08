package execrise1;

import java.util.concurrent.Semaphore;

public class ThreadAa extends Thread {
    Semaphore semA,semB;

    public ThreadAa(Semaphore semA, Semaphore semB) {
        this.semA = semA;
        this.semB = semB;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("END OF A");
                break;
            }
            try {
                semA.acquire();
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@THREAD A!!");
                //notifyAll(); to może być tylko poza watkiem którego się odnosi?
               // wait();
            } catch (InterruptedException e) {
                System.out.println("END OF A in catch");

                break;

            }
            finally {
                semB.release();
            }
        }
    }
}
