// Finds the minimum element in the unsorted part and swaps it with the first unsorted element.

public class Solution {
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i=0;i<n-1;i++) {
            int minIdx=i;
            for (int j=i+1; j<n; j++) {
                if (arr[j]<arr[minIdx]){
                    minIdx=j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printArray(int arr[]) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Selection Sort:");
        printArray(arr);
    }
}
