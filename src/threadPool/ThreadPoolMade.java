package threadPool;

public class ThreadPoolMade {

    /**
     * 스레드풀 만들기
     * 생각하는 구현 순서
     * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
     * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
     * 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩 묶어준다.
     * 4. 스레드를 잡고 가면서 task 를 실행을 하고 task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
     */

    public static void main(String[] args) throws IllegalAccessException, InterruptedException {

        CustomThreadPool customThreadPool = CustomThreadPool.create(5);
        TaskFiveSecond tk1 = new TaskFiveSecond();
        TaskFiveSecond tk2 = new TaskFiveSecond();
        TaskFiveSecond tk3 = new TaskFiveSecond();
        TaskFiveSecond tk4 = new TaskFiveSecond();
        TaskFiveSecond tk5 = new TaskFiveSecond();
        TaskFiveSecond tk6 = new TaskFiveSecond();
        TaskFiveSecond tk7 = new TaskFiveSecond();
        TaskFiveSecond tk8 = new TaskFiveSecond();
        TaskFiveSecond tk9 = new TaskFiveSecond();
        customThreadPool.addTask(tk1);
        customThreadPool.addTask(tk2);
        customThreadPool.addTask(tk3);
        customThreadPool.addTask(tk4);
        customThreadPool.addTask(tk5);
        customThreadPool.addTask(tk6);
        customThreadPool.addTask(tk7);
        customThreadPool.addTask(tk8);
        customThreadPool.addTask(tk9);

    }



}
