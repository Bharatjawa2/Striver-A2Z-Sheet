import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String[] words={"xbc","pcxbcf","xb","cxbc","pcxbc"};
        int ans=longestStrChain(words);
        System.out.println(ans);

    }
    public static int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(valid(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    static boolean valid(String a,String b){
        int n=a.length();
        int m=b.length();
        if(n!=m+1) return false;

        int i=0,j=0;
        boolean flag=false;
        while(i<n && j<m){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }else{
                if(flag) return false;
                flag=true;
                i++;
            }
        }
        return true;
    }
}