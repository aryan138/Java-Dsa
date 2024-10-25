package MultiThreading;

public class ManyThreadsSingleObject implements Runnable {
  String task;

  ManyThreadsSingleObject(String task) {
    this.task = task;
  }

  public void run() {
    for (int i = 0; i <= 5; i++) {
      System.out.println(task + " " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Name of thread" + Thread.currentThread());
    ManyThreadsSingleObject mt = new ManyThreadsSingleObject("Hello JAVA");
    Thread t1 = new Thread(mt);
    Thread t2 = new Thread(mt);
    Thread t3 = new Thread(mt);
    t1.start();
    t2.start();
    t3.start();
    int count = Thread.activeCount();
    System.out.println("No. of thread active " + count);
  }
}
