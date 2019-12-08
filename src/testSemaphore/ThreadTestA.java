package testSemaphore;

import java.util.concurrent.Semaphore;

public class ThreadTestA extends Thread{

    Semaphore sem;

    public ThreadTestA(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        int countLoop =0;
        while(true)
        {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countLoop++;
            System.out.println("Thread A work:"+countLoop);
            //wait() chyba nie może się znajdowac w obiekcie watku tylko wywolany przez obiekt koordynujacy
            //sem.release();

        }
    }
}
