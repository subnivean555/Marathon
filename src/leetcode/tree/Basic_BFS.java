package leetcode.tree;

import java.util.*;


public class Basic_BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> line = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                line.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(line);
        }

        return list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        bfs(root, 0, result);
        return result;
    }

    private void bfs(TreeNode node, int level, List<List<Integer>> result){
        if (node == null)
            return;
        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        bfs(node.left, level + 1, result);
        bfs(node.right, level + 1, result);
    }
}
