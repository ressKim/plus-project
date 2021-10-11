package threadPool;

public class CustomThread extends Thread {



    public CustomThread() {
        super();
    }

    public CustomThread(Runnable target) {
        super(target);
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        super.run();
    }
}
