package structure.tree;

import java.util.ArrayList;

public class AVLTree<Key extends Comparable<Key>, Value>  {

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int height;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int getHeight(Node node){
        if (node == null)
            return 0;
        else
            return node.height;
    }

    public void add(Key key, Value val){
        root = add(root, key, val);
    }

    private Node add(Node node, Key key, Value val) {
        if (node == null){
            size++;
            return new Node(key, val);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, val);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, val);
        else
            node.val = val;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return leftRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return rightRotate(node);
        }

        return node;
    }

    public Value remove(Key key){
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root, key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, Key key) {
        if (node == null)
            return null;
        Node retNode;
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                Node successor = mininmum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }
        }

        if (retNode == null)
            return null;
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        int balanceFactor = getBalanceFactor(retNode);

        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }

    public void set(Key key, Value value){
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.val = value;
    }

    public Value get(Key key){
        Node node = getNode(root, key);
        return node == null ? null : node.val;
    }

    public boolean contains(Key key){
        return getNode(root, key) == null;
    }

    private Node mininmum(Node node) {
        if (node.left == null)
            return node;
        else
            return mininmum(node.left);
    }

    private Node getNode(Node node, Key key) {
        if (node == null)
            return null;
        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);

    }

    /**
     *  对节点 y 进行向右操作, 返回旋转后新的节点 x
     *         y            x
     *        / \         /   \
     *       x  T4       z     y
     *      / \         / \   / \
     *     z   T3      T1 T2 T3 T4
     *    / \
     *   T1 T2
     * @param y
     * @return
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     *  对节点 y 进行向右操作, 返回旋转后新的节点 x
     *         y            x
     *        / \         /   \
     *       T1  x       y     z
     *          / \     / \   / \
     *        T2   z   T1 T2 T3 T4
     *            / \
     *           T3 T4
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private int getBalanceFactor(Node node){
        if (node == null)
            return 0;
         else
             return getHeight(node.left) - getHeight(node.right);
    }

    public boolean isBST(){
        ArrayList<Key> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++)
            if (keys.get(i-1).compareTo(keys.get(i)) > 0)
                return false;
        return true;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left)&&isBalanced(node.right);
    }

    private void inOrder(Node node, ArrayList<Key> keys) {
        if (node == null)
            return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

}
