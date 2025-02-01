class Solution {
    public static void main(String[] args) {
        int[] prices={1,3,2,8,4,9};
        int fee=2;
        int ans=maxProfit(prices,fee);
        System.out.println(ans);
    }
    public static int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        // Integer[][] dp=new Integer[n][2];
        int[][] dp=new int[n+1][2];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(-prices[i]-fee+dp[i+1][0],dp[i+1][1]);
                }else{
                    profit=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];
        // return solve(0,1,n,fee,prices,dp);
    }
    static int solve(int index,int buy,int n,int fee,int[] prices,Integer[][] dp){
        if(index==n) return 0;
        if(dp[index][buy]!=null) return dp[index][buy];

        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[index]-fee+solve(index+1,0,n,fee,prices,dp),solve(index+1,1,n,fee,prices,dp));
        }else{
            profit=Math.max(prices[index]+solve(index+1,1,n,fee,prices,dp),solve(index+1,0,n,fee,prices,dp));
        }
        return dp[index][buy]=profit;
    }
}