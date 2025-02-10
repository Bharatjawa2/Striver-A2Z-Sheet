class Solution {
    public static void main(String[] args) {
        int[] arr={1,4,6,3,7,3,7};
        int ans=getSecondLargest(arr);
        System.out.println(ans);
    }
    public static  int getSecondLargest(int[] arr) {
        if(arr==null || arr.length<2) return -1;
        
        int largest=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        
        for(int i:arr){
            if(i>largest){
                second=largest;
                largest=i;
            }else if(i<largest && i>second){
                second=i;
            }
        }
        
        return second==Integer.MIN_VALUE ? -1:second;
    }
}