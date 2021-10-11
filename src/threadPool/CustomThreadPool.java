package threadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 만들어보는 threadPool
 * <p>
 * threadCount - thread 갯수
 */
public class CustomThreadPool{

    /**
     * 스레드풀 만들기
     * 생각하는 구현 순서
     * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
     * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
     * 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩 묶어준다.
     * 4. 스레드를 잡고 가면서 task 를 실행을 하고 task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
     */
    private int threadCount;

    private ArrayList<Thread> threadList;

    Queue<Runnable> taskList = new LinkedList<>();

    public static CustomThreadPool createAndRun(int threadCount, Runnable task) throws InterruptedException {
        ArrayList<Thread> threadArrayList = new ArrayList<>();
        for (int i = 0; threadCount > i; i++) {
            Thread thread = new Thread(task);
            thread.start();
            thread.wait();
            threadArrayList.add(thread);
            System.out.println("thread " + (i+1) +"개 생성");
        }
        return new CustomThreadPool(threadCount, threadArrayList);
    }

    /**
     * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
     */
    public static CustomThreadPool create(int threadCount) throws IllegalAccessException {
        if (threadCount <= 0) {
            throw new IllegalAccessException("threadCount 는 0 이상이여야 합니다.");
        }

        ArrayList<Thread> threadArrayList = new ArrayList<>();
        for (int i = 0; threadCount > i; i++) {
            Thread thread = new Thread();
            threadArrayList.add(thread);
            System.out.println("thread " + (i+1) +"개 생성");
        }
        return new CustomThreadPool(threadCount, threadArrayList);
    }


    /**
     * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
     */
    public void runTask(Runnable task) {
        Queue<Runnable> taskList = new LinkedList<>();
//        taskList.add()

        for (Thread thread : threadList) {
            Thread.State state = thread.getState();
            if (state.equals(Thread.State.RUNNABLE)) {
//                thread.;
            }
        }
    }

    public void execute(Runnable task){
        Queue<Runnable> taskList = new LinkedList<>();
        taskList.add(task);

    }

    private CustomThreadPool(int threadCount) {
        this.threadCount = threadCount;
    }

    public CustomThreadPool(int threadCount, ArrayList<Thread> threadList) {
        this.threadCount = threadCount;
        this.threadList = threadList;
    }

    public int getThreadCount() {
        return threadCount;
    }

//    @Override
////    public void run() {
////        Random number = new Random();
////        System.out.println("TaskFiveSecond 작업 시작 = " + number);
////        try {
////            //thread 를 5초동안 멈춤
////            Thread.sleep(5000);
////            System.out.println("TaskFiveSecond 작업 끝 = " + number);
////        } catch (InterruptedException e) {
////            System.out.println("sleep exception = " + e);
////            e.printStackTrace();
//        }
//    }
}
