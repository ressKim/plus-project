package threadPool;

import java.lang.Thread.State;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://honbabzone.com/java/java-thread/
/**
 * 만들어보는 threadPool
 * <p>
 * threadCount - thread 갯수
 * <p>
 * 스레드풀 만들기 생각하는 구현 순서 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태) 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인
 * 스레드가 있는지 찾는다. 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩 묶어준다. 4. 스레드를 잡고 가면서 task 를 실행을 하고
 * task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
 */
public class CustomThreadPool {


  private int threadCount;

  private int maxThreadCount;

  private HashMap<String, Thread> threadListMap;

  private ArrayList<String> runningThreadNameList;

  private Queue<String> taskList;


  /**
   * 1. n 개의 스레드 생성을 요청 받으면 생성하고 들고있는다.(대기 상태) 1. 최대 스레드 갯수를 받는다.
   */
  public static CustomThreadPool create(int maxThreadCount) throws IllegalAccessException {
    if (maxThreadCount <= 0) {
      throw new IllegalAccessException("threadCount 는 0 이상이여야 합니다.");
    }

    // thread 를 threadCount 수만큼 생성 후 threadList 에 추가
    // thread max 를 정해 놓고 최대 스레드 갯수가 이 갯수를 못 넘도록 구현 방향 변경
    System.out.println("thread max 갯수는 =  " + maxThreadCount);

    //thread 갯수 만큼 thread 를 생성한 객체 반환
//    Queue<Runnable> taskList = new LinkedList<>();
//    return new CustomThreadPool(maxThreadCount, threadArrayList, taskList);
    return new CustomThreadPool(maxThreadCount);
  }

  //callback 형태로..

  /**
   * 2. task 작업을 요청을 하면 큐에 쌓고, 대기상태인 스레드가 있는지 찾는다. 3. 대기상태인 스레드가 큐에서 대기하고 있는 순서대로 남아있는 스레드와 하나씩
   * 묶어준다.
   */
  public void addTask(Runnable task) throws InterruptedException {
    String taskName = "name" + LocalDateTime.now();
    execute(taskName);
    threadListMap.put(taskName, new Thread(task, taskName));
    System.out.println("threadListMap = " + threadListMap);

    if (threadCount == 1) {
      runThreadPool();
    }
    if (threadCount != maxThreadCount) {
      runNextThreadPool();
    }
  }

  private void runNextThreadPool() {
    if (threadCount < maxThreadCount) {
      if (!taskList.isEmpty()) {
        String taskName = taskList.poll();
        Thread newTask = threadListMap.get(taskName);
        System.out.println("newTask = " + newTask);
        threadCount++;
        runningThreadNameList.add(taskName);
        newTask.start();
        endThreadRemove();
      }
    }
  }

  private void runThreadPool(){
    if (threadCount < maxThreadCount) {
      if (!taskList.isEmpty()) {
        String taskName = taskList.poll();
        Thread newTask = threadListMap.get(taskName);
        System.out.println("newTask = " + newTask);
        threadCount++;
        runningThreadNameList.add(taskName);
        newTask.start();
//        try {
//          newTask.join();
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
        endThreadRemove();
      }
    }
  }

  private void endThreadRemove() {
    ArrayList<String> tempList = new ArrayList<>();
    for (String s : runningThreadNameList) {
      Thread getThread = threadListMap.get(s);

      if (!getThread.isAlive()) {
        threadCount--;
        tempList.add(s);
        System.out.println("-작업 종료 후 runningThreadNameList = " + runningThreadNameList);
      }
    }
    for (String s : tempList) {
      runningThreadNameList.remove(s);
    }

  }

  /**
   * 4. 스레드를 잡고 가면서 task 를 실행을 하고 task 가 끝나면 스레드를 다시 돌려준다.(스레드는 대기상태로 다시 반환)
   */

  //큐에 작업 추가
  public void execute(String taskName) {
    taskList.offer(taskName);
    System.out.println("----- 쌓여있는 작업갯수 =  "+ taskList.size() + "개 ");
  }

  //큐에 다음 작업 들고오기
  public Runnable getNextTask() {
    if (taskList.size() == 0) {
      System.out.println("threadCount = 0 " + "작업할 게 없습니다.");
      return null;
    }
    String runnableName = taskList.poll();
    return threadListMap.get(runnableName);
  }

  public CustomThreadPool(int maxThreadCount) {
    this.threadCount = 0;
    this.maxThreadCount = maxThreadCount;
    this.threadListMap = new HashMap<>();
    this.runningThreadNameList = new ArrayList<>();
    this.taskList = new LinkedList<>();
  }

  public int getThreadCount() {
    return threadCount;
  }

  public HashMap<String, Thread> getThreadList() {
    return threadListMap;
  }

  public Queue<String> getTaskList() {
    return taskList;
  }
}
