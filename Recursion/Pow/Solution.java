class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    public static double myPow(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(nn<0) nn=-1*nn;

        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn--;
            }else{
                x*=x;
                nn/=2;
            }
        }
        if(n<0) return (double)1.0/(double)ans;
        return ans;
    }
}