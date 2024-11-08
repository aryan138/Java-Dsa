public class Editdistance {

    static int editDistance(String s1, String s2, int n, int m) {
        // Base cases
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        // If last characters are the same, no need to edit this character
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return editDistance(s1, s2, n - 1, m - 1);
        }

        // If last characters are different, consider all three operations
        return 1 + Math.min(
                editDistance(s1, s2, n, m - 1), // Insert
                Math.min(
                        editDistance(s1, s2, n - 1, m), // Remove
                        editDistance(s1, s2, n - 1, m - 1) // Replace
                ));
    }

    public static void main(String[] args) {
        String s = "hello";
        String s1 = "seldom";
        int result = editDistance(s, s1, s.length(), s1.length());
        System.out.println("Edit Distance: " + result);
    }
}
