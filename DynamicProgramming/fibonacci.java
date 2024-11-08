class fibonacci {

    public static int fib_recursion(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib_recursion(n - 1) + fib_recursion(n - 2);
    }

    public static int fib_memoization(int n, int f[]) {
        if (n == 0 || n == 1)
            return n;
        if (f[n] != 0)
            return f[n];
        f[n] = fib_memoization(n - 1, f) + fib_memoization(n - 2, f);
        return f[n];
    }

    public static int fib_tabulation(int n) {
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];

    }

    public static void main(String[] args) {
        int n=6;
        System.out.println(fib_recursion(n));
        System.out.println(fib_memoization(n, new int[n + 1]));// array [0,0,0,0,0,0]
        System.out.println(fib_tabulation(n));
    }
}