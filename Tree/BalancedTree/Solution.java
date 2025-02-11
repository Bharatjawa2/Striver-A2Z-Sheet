import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        boolean ans=Balanced(root);
        System.out.println(ans);
    }
    public static boolean Balanced(TreeNode root) {
        return solve(root)==-1?false:true;
    }
    static int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        if(left==-1) return -1;
        int right=solve(root.right);
        if(right==-1) return -1;

        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
