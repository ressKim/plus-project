package threadPool;

public class TaskFiveSecond implements Runnable {

  @Override
  public void run() {
//    System.out.println("TaskFiveSecond 작업 시작");
    try {
      //thread 를 5초동안 멈춤
      Thread.sleep(500);
//      System.out.println("TaskFiveSecond 작업 끝 ");
    } catch (InterruptedException e) {
      System.out.println("sleep exception " + e);
      e.printStackTrace();
    }

  }

  public TaskFiveSecond() {
  }
}
