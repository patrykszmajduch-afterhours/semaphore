package testSemaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);


        Thread t1 = new ThreadTestA(sem);
        Thread t2 = new ThreadTestB(sem);
        t1.start();
        t2.start();
    }



}
