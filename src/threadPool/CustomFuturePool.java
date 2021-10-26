package threadPool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

//https://honbabzone.com/java/java-thread/

/**
 * 만들어보는 threadPool
 * <p>
 * threadCount - thread 갯수
 * <p>
 * 스레드풀 만들기 생각하는 구현 순서
 * <p>
 * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
 * <p>
 * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
 * <p>
 * 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩 묶어준다.
 * <p>
 * 4. 스레드를 잡고 가면서 task 를 실행을 하고 task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
 */
public class CustomFuturePool {


  private int threadCount;

  private int maxThreadCount;

  private Queue<Runnable> taskQueue;


  /**
   * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태) 1. 최대 스레드 갯수를 받는다.
   */
  public static CustomFuturePool create(int maxThreadCount) throws IllegalAccessException {
    if (maxThreadCount <= 0) {
      throw new IllegalAccessException("threadCount 는 0 이상이여야 합니다.");
    }

    // thread 를 threadCount 수만큼 생성 후 threadList 에 추가
    System.out.println("thread max 갯수는 =  " + maxThreadCount);

    //thread 갯수 만큼 thread 를 생성한 객체 반환
    return new CustomFuturePool(maxThreadCount);
  }

  //callback 형태로..

  /**
   * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다. 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩
   * 묶어준다.
   */
  public void addTask(Runnable task) {
    execute(task);
//    System.out.println("task queue = " + taskQueue);
    customThreadPoolRun();
  }

  public void run() {
    if (nextTaskCheck()) {
      int bound = taskQueue.size();
      IntStream.range(0, bound - 1).filter(i -> checkPoolMaxCount())
          .forEach(i -> runTask(getNextTask()));
    }
  }

  private void customThreadPoolRun() {
    if (nextTaskCheck()) {
      if (checkPoolMaxCount()) {
        runTask(getNextTask());
      } else {
        System.out.println("--- task poll 이 꽉 찼습니다 ");
      }
    } else {
      System.out.println("--- 다음 작업이 없습니다.");
//      System.exit(0);
    }
  }

  private boolean nextTaskCheck() {
    return !taskQueue.isEmpty();
  }

  private boolean checkPoolMaxCount() {
    return threadCount < maxThreadCount;
  }

  public void runTask(Runnable task) {
    threadCount += 1;
    System.out.println("taskQueue = " + taskQueue.size());
    ExecutorService executor
        = Executors.newSingleThreadExecutor();
    Future<Integer> integerFuture = executor.submit(() -> {
      System.out.println("--- task start");
      task.run();
      return 1;
    });
    try {
      //최대 이 시간까지는 기다려주고 이거보다 더 걸리면 그냥 종료 시킨다.
      Integer taskEndCheck = integerFuture.get(100, TimeUnit.SECONDS);
      if (taskEndCheck == 1) {
        System.out.println("--- task end");
        threadCount -= 1;
        customThreadPoolRun();
      }
    } catch (ExecutionException | TimeoutException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void execute(Runnable task) {
    taskQueue.offer(task);
    System.out.println("task execute 추가, queue size = " + taskQueue.size());
  }

  public Runnable getNextTask() {
    if (taskQueue.size() == 0) {
      System.out.println("threadCount = 0 " + "작업할 게 없습니다.");
      return null;
    }
    return taskQueue.poll();
  }

  public CustomFuturePool(int maxThreadCount) {
    this.threadCount = 0;
    this.maxThreadCount = maxThreadCount;
    this.taskQueue = new LinkedList<>();
  }

}
