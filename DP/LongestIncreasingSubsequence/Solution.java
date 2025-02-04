public class Solution {
    public static void main(String[] args) {
        int[] arr={10,9,2,3,5,6,2,45,9,101};
        int ans=LIC(arr);
        System.out.println(ans);
    }    

    static int LIC(int[] arr){
        int n=arr.length;
        // Integer[][] dp=new Integer[n][n+1];
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int not=dp[i+1][j+1];
                int take=0;
                if(j==-1 || arr[i]>arr[j]){
                    take=1+dp[i+1][i+1];
                }
                dp[i][j+1]=Math.max(not,take);
            }
        }
        return dp[0][0];
        // return solve(0,-1,n,arr,dp);
    }
    static int solve(int index,int prev,int n,int[] arr,Integer[][] dp){
        if(index==n) return 0;
        if(dp[index][prev+1]!=null) return dp[index][prev+1];

        int not=solve(index+1,prev,n,arr,dp);
        int take=0;
        if(prev==-1 || arr[index]>arr[prev]){
            take=1+solve(index+1,index,n,arr,dp);
        }
        return dp[index][prev+1]=Math.max(take,not);
    }
}
