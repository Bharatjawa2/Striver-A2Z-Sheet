class Solution {
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        int ans=maxProfit(prices);
        System.out.println(ans);
    }
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        // Integer[][] dp=new Integer[n][4];
        int[][][] dp=new int[n+1][2][3];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=2;k++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                    }else{
                        profit=Math.max(prices[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
                    }
                    dp[i][j][k]=profit;
                }
            }
        }
        return dp[0][1][2];
        // return solve(0,0,1,n,prices,dp);
    }
    static int solve(int index,int trans,int buy,int n,int[] prices,Integer[][] dp){
        if(index==n || trans==4) return 0;
        if(dp[index][trans]!=null) return dp[index][trans];

        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[index]+solve(index+1,trans+1,0,n,prices,dp),solve(index+1,trans,1,n,prices,dp));
        }else{
            profit=Math.max(prices[index]+solve(index+1,trans+1,1,n,prices,dp),solve(index+1,trans,0,n,prices,dp));
        }
        return dp[index][trans]=profit;
    }
}