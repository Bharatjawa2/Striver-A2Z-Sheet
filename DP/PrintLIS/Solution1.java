import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

class Solution1 {
    public static void main(String[] args) {
        int[] arr={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int n=16;
        List<Integer> l=new ArrayList<>();
        l=longestIncreasingSubsequence(n,arr);
        System.out.println(l);
    }
    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i:nums) set.add(i);
        ArrayList<Integer> list=new ArrayList<>(set);
        int m=set.size();

        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i-1]==list.get(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        ArrayList<Integer> l=new ArrayList<>();
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(nums[i-1]==list.get(j-1)){
                l.add(nums[i-1]);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        Collections.reverse(l);
        return l;
    }
}