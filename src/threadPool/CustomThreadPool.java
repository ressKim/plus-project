package threadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 만들어보는 threadPool
 * <p>
 * threadCount - thread 갯수
 * <p>
 * 스레드풀 만들기
 * 생각하는 구현 순서
 * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
 * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
 * 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩 묶어준다.
 * 4. 스레드를 잡고 가면서 task 를 실행을 하고 task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
 */
public class CustomThreadPool {


    private int threadCount;

    private ArrayList<Thread> threadList;

    private Queue<Runnable> taskList;

    /**
     * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
     */
    public static CustomThreadPool create(int threadCount) throws IllegalAccessException {
        if (threadCount <= 0) {
            throw new IllegalAccessException("threadCount 는 0 이상이여야 합니다.");
        }

        // thread 를 threadCount 수만큼 생성 후 threadList 에 추가
        ArrayList<Thread> threadArrayList = new ArrayList<>();
        for (int i = 0; threadCount > i; i++) {
            threadArrayList.add(new Thread());
            System.out.println("thread " + (i + 1) + "개 생성");
        }

        //thread 갯수 만큼 thread 를 생성한 객체 반환
        Queue<Runnable> taskList = new LinkedList<>();
        return new CustomThreadPool(threadCount, threadArrayList, taskList);
    }


    /**
     * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
     * 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩 묶어준다.
     */
    public void runTask(Runnable task) {
        execute(task);
        /**
         * Runnable - 실행 가능 상태 인 스레드가있으면 '이 작업' 을 시작
         */
        for (Thread thread : threadList) {
            Thread.State state = thread.getState();
            //Thread 중 wait 상태가 있으면 실행 대기 상태로 만들어 준다.
            if (state.equals(Thread.State.WAITING)) {
                thread.notify();
            }
            if (state.equals(Thread.State.RUNNABLE)) {

                //스레드에서 추가 작업을 실행하는 법...??
                Runnable nextTask = getNextTask();
                thread.start();

                //작업이 끝나면 대기 상태로 변경하는 로직 추가 필요
                /**
                 * 4. 스레드를 잡고 가면서 task 를 실행을 하고 task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
                 */
//                thread.wait();
                return;
            }

        }
    }

    //큐에 작업 추가
    public void execute(Runnable task) {
        taskList.offer(task);
    }

    //큐에 다음 작업 들고오기
    public Runnable getNextTask() {
        return taskList.poll();
    }

    private CustomThreadPool(int threadCount, ArrayList<Thread> threadList, Queue<Runnable> taskList) {
        this.threadCount = threadCount;
        this.threadList = threadList;
        this.taskList = taskList;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public ArrayList<Thread> getThreadList() {
        return threadList;
    }

    public Queue<Runnable> getTaskList() {
        return taskList;
    }
}
