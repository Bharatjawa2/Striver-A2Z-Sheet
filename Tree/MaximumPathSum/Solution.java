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
        int ans=maxPathSum(root);
        System.out.println(ans);
    }
    static int max=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }
    static int solve(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(0,solve(root.left));
        int right=Math.max(0,solve(root.right));
        max=Math.max(max,root.data+left+right);
        return root.data+Math.max(left,right);
    }
}
