class Solution {
    public static void main(String[] args) {
        int[] prices={1,2,3,0,2};
        int ans=maxProfit(prices);
        System.out.println(ans);
    }
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        // Integer[][] dp=new Integer[n][2];
        int[][] dp=new int[n+2][2];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    profit=Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }
        }

        return dp[0][1];
        // return solve(0,n,1,prices,dp);
    }
    static int solve(int index,int n,int buy,int[] prices,Integer[][] dp){
        if(index>=n) return 0;
        if(dp[index][buy]!=null) return dp[index][buy];

        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[index]+solve(index+1,n,0,prices,dp),solve(index+1,n,1,prices,dp));
        }else{
            profit=Math.max(prices[index]+solve(index+2,n,1,prices,dp),solve(index+1,n,0,prices,dp));
        }
        return dp[index][buy]=profit;
    }
}