// Builds a sorted array one element at a time by shifting larger elements to the right.

public class Solution {
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int arr[]) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println("Insertion Sort:");
        printArray(arr);
    }
}
