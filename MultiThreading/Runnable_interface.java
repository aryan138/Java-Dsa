package MultiThreading;

class Mythread1 implements Runnable {
  public void run() {
    System.out.println("thread running");
  }
}

public class Runnable_interface {
  public static void main(String[] args) {
    Mythread1 mt = new Mythread1();
    Thread t = new Thread(mt);
    t.start();
  }
}
