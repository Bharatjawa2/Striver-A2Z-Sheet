import java.util.ArrayList;
import java.util.List;

public class Backtrack {
    public static void main(String[] args) {
        int n=16;
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        List<Integer> ans=new ArrayList<>();
        ans=longestIncreasingSubsequence(n,arr);
        System.out.println(ans);
    }
    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
       ArrayList<Integer> result=new ArrayList<>();
       ArrayList<Integer> temp=new ArrayList<>();
       
       int prev=-1;
       solve(0,n,arr,result,temp,prev);
       
       return result;
    }
    
    static void solve(int index,int n,int[] arr,ArrayList<Integer> result,ArrayList<Integer> temp,int prev){
        if(index>=n){
            if(temp.size()>result.size()){
                result.clear();
                result.addAll(temp);
            }
            return;
        }
        
        if(prev==-1 || arr[index]>prev){
            temp.add(arr[index]);
            solve(index+1,n,arr,result,temp,arr[index]);
            temp.remove(temp.size()-1);
        }
        solve(index+1,n,arr,result,temp,prev);
    }
}


