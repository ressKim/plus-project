package threadPool;

import java.util.Random;

public class TaskFiveSecond implements Runnable{

    @Override
    public void run() {
        Random number = new Random();
        System.out.println("TaskFiveSecond 작업 시작 = " + number);
        try {
            //thread 를 5초동안 멈춤
            Thread.sleep(5000);
            System.out.println("TaskFiveSecond 작업 끝 = " + number);
        } catch (InterruptedException e) {
            System.out.println("sleep exception = " + e);
            e.printStackTrace();
        }
    }
}
