package threadPool;

public class CustomThread extends Thread {

//  Thread newThread;

//  public static CustomThread createThread(Runnable runnable, String threadName) {
//    System.out.println("-- 새로운 작업 스레드 생성");
//    Thread thread = new Thread(runnable, threadName);
//    return new CustomThread(runnable, threadName, thread);
//  }

  public CustomThread(Runnable target, String name) {
    super(target, name);
    System.out.println("-- 새로운 작업 스레드 생성");
//    this.newThread = newThread;
  }

}
