//subset sum
//5
//1 4 5 10 16
//sum 9
public class CheckSubsetSum {
    public static  boolean  subsetSum(int arr[],int n,int sum){
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for (int i = 0; i < n; i++) {
            for(int j=sum;j>=arr[i];j--){
                dp[j]=dp[j]||dp[j-arr[i]];
                if(dp[sum]==true)
                return true;
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        //sorted array needed
        int n=5;
        int arr[]={1,4,5,10,16};
        int sum=9;
        System.out.println(subsetSum(arr, n, sum));
    }
}
