import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 3, 5, 6, 2, 45, 9, 101};
        List<Integer> lis = LIC(arr);
        System.out.println("Length of LIS: " + lis.size());
        System.out.println("LIS Sequence: " + lis);
    }

    static List<Integer> LIC(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int[] index = new int[n]; 
        int[] parent = new int[n]; 
        Arrays.fill(parent, -1);

        list.add(arr[0]);
        index[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                parent[i] = index[list.size() - 1];
                list.add(arr[i]);
                index[list.size() - 1] = i;
            } else {
                int pos = binarySearch(list, arr[i]); 
                list.set(pos, arr[i]);
                index[pos] = i;
                if (pos > 0) {
                    parent[i] = index[pos - 1]; 
                }
            }
        }

        List<Integer> lis = new ArrayList<>();
        int lastIndex = index[list.size() - 1];
        while (lastIndex != -1) {
            lis.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        Collections.reverse(lis);     
        return lis;
    }

    static int binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low; // Correct position for replacement
    }
}
