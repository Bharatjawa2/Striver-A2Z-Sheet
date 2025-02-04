import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 3, 5, 6, 2, 45, 9, 101};
        int ans = LIC(arr);
        System.out.println("Length of LIS: " + ans);
    }

    static int LIC(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]); 
        
        for (int i = 1; i < n; i++) { 
            if (arr[i] > list.get(list.size() - 1)) { 
                list.add(arr[i]); 
            } else { 
                int ind = binarySearch(list, arr[i]); 
                list.set(ind, arr[i]); 
            }
        }
        
        return list.size(); 
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
        return low; 
    }
}
