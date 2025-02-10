public class Easy {
    public static void main(String[] args) {
        int[] arr={10,9,2,3,5,6,2,45,9,101};
        int n=arr.length;
        
        int[] dp=new int[n];

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
