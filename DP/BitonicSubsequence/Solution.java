import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n=3;
        int[] arr={5,7,9};
        int ans=LongestBitonicSequence(n,arr);
        System.out.println(ans);
    }
    public static int LongestBitonicSequence(int n, int[] arr) {
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && 1+dp1[j]>dp1[i]){
                    dp1[i]=dp1[j]+1;
                }
            }
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[j]<arr[i] && 1+dp2[j]>dp2[i]){
                    dp2[i]=dp2[j]+1;
                }
            }
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            if(dp1[i]!=1 && dp2[i]!=1) // if Strictly Increasing or Strictly Decreasing is not allowed
                max=Math.max(max,dp1[i]+dp2[i]-1);
        }
        
        return max;
    }
}