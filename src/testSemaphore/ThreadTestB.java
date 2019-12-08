package testSemaphore;

import java.util.concurrent.Semaphore;

public class ThreadTestB extends Thread{

    Semaphore sem;

    public ThreadTestB(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        int countLoop =0;
        while(true)
        {
            try {
                Thread.sleep(50);
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }


            countLoop++;
            System.out.println("Thread B work:"+countLoop);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            notifyAll();
            //sem.release();

        }
    }
}
