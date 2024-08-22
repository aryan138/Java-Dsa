package class16;

interface Moveable {
  int avg_speed = 40;

  void move();
}

interface Rollable extends Moveable {
  boolean isRollable();
}

public class interface_class implements Rollable {
  public void move() {
    System.out.println("Average speed is " + avg_speed);
  }

  public boolean isRollable() {
    return true;
  }

  public static void main(String[] args) {
    interface_class c = new interface_class();
    c.move();
    System.out.println(c.isRollable());
  }
}
