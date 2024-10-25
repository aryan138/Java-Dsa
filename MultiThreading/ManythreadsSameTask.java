package MultiThreading;

public class ManythreadsSameTask extends Thread {
  String task;

  ManythreadsSameTask(String task) {
    this.task = task;
  }

  public void run() {
    for (int i = 1; i <= 5; i++) {
      System.out.println(task + " : " + i);
      try {
        Thread.sleep(1000); // Pause the thread execution for 1000 milliseconds.
      } catch (InterruptedException ie) {
        System.out.println(ie.getMessage());
      }
    } // end of for loop.
  } // end of run() method.

  public static void main(String[] args) {
    // Create two objects to represent two tasks.
    ManythreadsSameTask th1 = new ManythreadsSameTask("Cut the ticket");
    ManythreadsSameTask th2 = new ManythreadsSameTask("Show your seat number");
    // Thread t1 = new Thread(th1);
    // Thread t2 = new Thread(th2);
    th1.start();
    th2.start();
  }
}