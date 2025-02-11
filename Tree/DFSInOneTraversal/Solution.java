import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
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

        List<List<Integer>> ans = allTraversals(root);
        System.out.println("Preorder: " + ans.get(0));
        System.out.println("Inorder: " + ans.get(1));
        System.out.println("Postorder: " + ans.get(2));
    }

    public static List<List<Integer>> allTraversals(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) return Arrays.asList(pre, in, post);

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair it = st.pop();

            if (it.num == 1) { // Preorder
                pre.add(it.node.val);
                it.num++;
                st.push(it);
                if (it.node.left != null) st.push(new Pair(it.node.left, 1));

            } else if (it.num == 2) { // Inorder
                in.add(it.node.val);
                it.num++;
                st.push(it);
                if (it.node.right != null) st.push(new Pair(it.node.right, 1));

            } else { // Postorder
                post.add(it.node.val);
            }
        }

        return Arrays.asList(pre, in, post);
    }

    static class Pair {
        TreeNode node;
        int num;  // 1 -> Pre, 2 -> In, 3 -> Post
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
