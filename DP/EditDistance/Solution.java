class Solution {
    public static void main(String[] args) {
        String word1="horse";
        String word2 = "ros";
        int ans=minDistance(word1,word2);
        System.out.println(ans);
    }
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        // Integer[][] dp=new Integer[m][n];
        int[][] dp=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
            }
        }

        return dp[m][n];
        // return solve(word1,word2,m-1,n-1,dp);
    }
    static int solve(String s,String t,int i,int j,Integer[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=null) return dp[i][j];

        int min=Integer.MAX_VALUE;
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=solve(s,t,i-1,j-1,dp);
        else{
            int insert=solve(s,t,i,j-1,dp);
            int delete=solve(s,t,i-1,j,dp);
            int replace=solve(s,t,i-1,j-1,dp);
            min=Math.min(insert,Math.min(replace,delete))+1;
        }
        return dp[i][j]=min;
    }
}