class Solution {
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        boolean ans=check(arr);
        System.out.println(ans);
    }
    public static boolean check(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                c++;
            }
        }   
        return c<=1 ? true:false;
    }
}
