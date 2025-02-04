import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,8};
        List<Integer> ans = LIC(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + ans.size());
        System.out.println("Longest Increasing Subsequence: " + ans);
    }

    static List<Integer> LIC(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // DP array to store LIS length at each index
        int[] parent = new int[n]; // Parent array to reconstruct the LIS path
        Arrays.fill(dp, 1); 
        Arrays.fill(parent, -1);

        int maxLength = 1, lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j]==0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j; // Store previous index
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct LIS
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        Collections.reverse(lis); // Reverse to get the correct sequence
        return lis;
    }
}
