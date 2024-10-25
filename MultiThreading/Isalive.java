package MultiThreading;

public class Isalive extends Thread {
  public void run() {
    System.out.println("r1");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ie) {
      System.out.println(ie.getMessage());
    }
    System.out.println("r2");
  }

  public static void main(String[] args) {
    Isalive th1 = new Isalive();
    Isalive th2 = new Isalive();
    th1.start();
    th2.start();
    System.out.println(th1.isAlive());
    System.out.println(th2.isAlive());
  }
}
