package class16;

import java.util.ArrayList;
import java.util.Scanner;

public class pipe {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String pipes = in.next();
    ArrayList<Integer> pipeList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      pipeList.add(Character.getNumericValue(pipes.charAt(i)));
    }

    boolean found;
    do {
      found = false;
      ArrayList<Integer> remainingPipes = new ArrayList<>();
      remainingPipes.add(pipeList.get(0));

      for (int i = 1; i < pipeList.size(); i++) {
        if (pipeList.get(i) > pipeList.get(i - 1)) {
          found = true;
        } else {
          remainingPipes.add(pipeList.get(i));
        }
      }

      pipeList = remainingPipes;

    } while (found);

    for (int pipe : pipeList) {
      System.out.print(pipe);
    }
    System.out.println();
  }
}
