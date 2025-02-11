class Solution {
    public static void main(String[] args) {
        int[] arr={1,3,2};
        nextPermutation(arr);
        for(int i:arr)System.out.print(i+" ");
    }
    public static void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind=-1;

        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                ind=i;
                break;
            }
        }

        if(ind==-1){
            reverse(nums,0,n-1);
            return;
        }

        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(nums,i,ind);
                break;
            }
        }

        reverse(nums,ind+1,n-1);
    }

    static void swap(int[] nums,int st,int end){
        int temp=nums[st];
        nums[st]=nums[end];
        nums[end]=temp;
    }

    static void reverse(int[] nums,int st,int end){
        while(st<end){
            swap(nums,st++,end--);
        }
    }
}