import java.util.ArrayList;
import java.util.ListIterator;

class Main {
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      al.add(i);
    }
    System.out.println("Original ArrayList: " + al);

    ListIterator<Integer> ltr = al.listIterator();
    while (ltr.hasNext()) {
      int i = ltr.next();
      System.out.print(i + " ");
      if (i % 2 == 0) {
        i++;
        ltr.set(i);
        ltr.add(i);
      }
    }
    System.out.println();
    System.out.println("Modified ArrayList: " + al);
  }
}
