import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<Integer> ans=new ArrayList<>();
        ans=largestDivisibleSubset(nums);
        System.out.println(ans);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] prev=new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);

        int max=1,last=0; 

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }

        List<Integer> list=new ArrayList<>();
        while(last!=-1){
            list.add(nums[last]);
            last=prev[last];
        }
        Collections.reverse(list);
        return list;
    }
}