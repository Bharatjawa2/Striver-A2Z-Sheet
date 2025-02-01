class Solution {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        int ans=maxProfit(prices);
        System.out.println(ans);
    }
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        // Integer[][] dp=new Integer[n][2];
        int[][] dp=new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;

        int profit=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    profit=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];

        // return solve(0,1,n,prices,dp);
    }
    static int solve(int index,int buy,int n,int[] prices,Integer[][] dp){
        if(index==n){
            return 0;
        }
        if(dp[index][buy]!=null) return dp[index][buy];

        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[index]+solve(index+1,0,n,prices,dp),solve(index+1,1,n,prices,dp));
        }else{
            profit=Math.max(prices[index]+solve(index+1,1,n,prices,dp),solve(index+1,0,n,prices,dp));
        }
        return dp[index][buy]=profit;
    }
}