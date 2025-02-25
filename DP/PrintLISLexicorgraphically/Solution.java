import java.util.*;

class Solution{
    static int longestIncreasingSubsequence(int arr[], int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {

            hash[i] = i;
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i] && 1 + dp[prev_index] > dp[i]) {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + " ");
        }
        System.out.println();

        return ans;
    }

    public static void main(String args[]) {

        int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        int n = arr.length;
        longestIncreasingSubsequence(arr, n);

    }
}