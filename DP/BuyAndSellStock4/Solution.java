class Solution {
    public static void main(String[] args) {
        int[] prices={3,2,6,5,0,3};
        int k=2;
        int ans=maxProfit(k,prices);
        System.out.println(ans);
    }
    public static int maxProfit(int k, int[] prices) {
        int n=prices.length;
        // Integer[][][] dp=new Integer[n][2][2*k+1];
        int[][][] dp=new int[n+1][2][2*k+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int t=1;t<=2*k;t++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(-prices[i]+dp[i+1][0][t-1],dp[i+1][1][t]);
                    }else{
                        profit=Math.max(prices[i]+dp[i+1][1][t-1],dp[i+1][0][t]);
                    }
                    dp[i][j][t]=profit;
                }
            }
        }
        return dp[0][1][2*k];
        // return solve(0,2*k,1,n,prices,dp);
    }
    static int solve(int index,int trans,int buy,int n,int[] prices,Integer[][][] dp){
        if(index==n || trans==0) return 0;
        if(dp[index][buy][trans]!=null) return dp[index][buy][trans];

        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[index]+solve(index+1,trans-1,0,n,prices,dp),solve(index+1,trans,1,n,prices,dp));
        }else{
            profit=Math.max(prices[index]+solve(index+1,trans-1,1,n,prices,dp),solve(index+1,trans,0,n,prices,dp));
        }
        return dp[index][buy][trans]=profit;
    }
}