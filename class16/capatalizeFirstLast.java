package class16;

public class capatalizeFirstLast {
  public static void main(String[] args) {
    String sentence = "this is an example sentence";
    String result = capitalizeFirstAndLast(sentence);
    System.out.println(result);
  }

  public static String capitalizeFirstAndLast(String sentence) {
    String[] ws = sentence.split(" ");
    StringBuilder cs = new StringBuilder();

    for (String w : ws) {
      if (w.length() > 1) {
        String cw = w.substring(0, 1).toUpperCase() +
            w.substring(1, w.length() - 1) +
            w.substring(w.length() - 1).toUpperCase();
        cs.append(cw).append(" ");
      } else {
        cs.append(w.toUpperCase()).append(" ");
      }
    }
    return cs.toString().trim();
  }
}
