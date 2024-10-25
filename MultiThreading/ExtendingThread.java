package MultiThreading;

class MyThread2 extends Thread {
  public void run() {
    System.out.println("Concurrent Threading");
  }
}

public class ExtendingThread {
  public static void main(String[] args) {
    MyThread2 mt = new MyThread2();
    mt.start();
  }
}
