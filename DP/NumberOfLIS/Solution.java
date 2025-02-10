import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr={1,3,5,4,7};
        int ans=findNumberOfLIS(arr);
        System.out.println(ans);
    }
    public static int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int max=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }
                else if(arr[i]>arr[j] && dp[i]==dp[j]+1){
                    cnt[i]+=cnt[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) ans+=cnt[i];
        }
        return ans;
    }
}