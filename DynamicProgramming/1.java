class Solution {
    public int minChanges(String s) {
        int ans = 0;
        int n = s.length();
        int i = 0;
        while(i+1<n){
            int ch1 = s.charAt(i)-'0';
            int ch2 = s.charAt(i+1)-'0';
            if(ch1 != ch2){
                ans+=1;
            }
            i=i+2;
        }
        return ans;
    }
}