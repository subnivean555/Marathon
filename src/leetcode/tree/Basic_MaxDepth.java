package leetcode.tree;

public class Basic_MaxDepth {

    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        else
            return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }

}
