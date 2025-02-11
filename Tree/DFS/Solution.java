import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    // Constructors
    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

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

        List<List<Integer>> ans = getTreeTraversal(root);
        System.out.println("Inorder Traversal: " + ans.get(0));
        System.out.println("Preorder Traversal: " + ans.get(1));
        System.out.println("Postorder Traversal: " + ans.get(2));
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(inorder(root));
        ans.add(preorder(root));
        ans.add(postorder(root));
        return ans;
    }

    static List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderHelper(root, list);
        return list;
    }

    static void inorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderHelper(root.left, list);
        list.add(root.data);
        inorderHelper(root.right, list);
    }

    static List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderHelper(root, list);
        return list;
    }

    static void preorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.data);
        preorderHelper(root.left, list);
        preorderHelper(root.right, list);
    }

    static List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    static void postorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderHelper(root.left, list);
        postorderHelper(root.right, list);
        list.add(root.data);
    }
}
