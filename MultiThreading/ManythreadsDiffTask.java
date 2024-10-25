package MultiThreading;

class myth1 implements Runnable {
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("First " + i);
    }
    System.out.println("First Exited");
  }
}

class myth2 implements Runnable {
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Second " + i);
    }
    System.out.println("Second Exited");
  }
}

public class ManythreadsDiffTask {
  public static void main(String[] args) {
    myth1 th1 = new myth1();
    Thread t1 = new Thread(th1);
    t1.start();
    myth2 th2 = new myth2();
    Thread t2 = new Thread(th2);
    t2.start();
    int j = 0;
    while (j < 4) {
      System.out.println("Main " + j);
      j += 1;
    }
    System.out.println("Main exited");
  }
}
