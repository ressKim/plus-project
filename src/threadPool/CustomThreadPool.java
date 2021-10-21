package threadPool;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
public class CustomThreadPool {


  private int threadCount;

  private int maxThreadCount;

  private HashMap<String, Thread> threadHashMap;

  private Queue<Runnable> taskQueue;

  /**
   * <p>
   * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태)
   * <p>
   */
  public static CustomThreadPool create(int maxThreadCount) {
    HashMap<String, Thread> threadHashMap = new HashMap<>();
    for (int i = 0; maxThreadCount > i; i++) {
      String threadName = "Th-" + (int) (Math.random() * 100000);
      Thread thread = new Thread(threadName);
      threadHashMap.put(threadName, thread);

    }
    return new CustomThreadPool(maxThreadCount, threadHashMap);
  }


  /**
   * <p>
   * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다.
   * <p>
   */
  public void addTask(Runnable task) {
    execute(task);
//    find
  }

  private void execute(Runnable task) {
    taskQueue.offer(task);
    System.out.println("-- taskQueue.size() = " + taskQueue.size());
  }

  private CustomThreadPool(int maxThreadCount,
      HashMap<String, Thread> threadHashMap) {
    this.threadCount = 0;
    this.maxThreadCount = maxThreadCount;
    this.threadHashMap = threadHashMap;
    this.taskQueue = new LinkedList<>();
  }
}
