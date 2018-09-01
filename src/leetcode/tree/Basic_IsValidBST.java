package leetcode.tree;

/**
 * https://github.com/kevin-wayne/algs4/blob/master/src/main/java/edu/princeton/cs/algs4/BST.java
 */
public class Basic_IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long min, long max) {
       if (root == null) {
           return true;
       }
       if (root.val <= min || root.val>= max){
           return false;
       }
       return valid(root.left, min, root.val)&&valid(root.right, root.val, max);
    }

}
