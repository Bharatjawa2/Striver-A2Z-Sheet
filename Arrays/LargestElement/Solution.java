class Solution {
    public static void main(String[] args) {
        int arr[]={2,45,3,56,2,5,3};
        int ans=largest(arr);
        System.out.println(ans);
    }
    public static int largest(int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            max=Math.max(max,i);
        }
        return max;
    }
}
