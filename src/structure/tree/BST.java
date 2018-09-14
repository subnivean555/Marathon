package structure.tree;

import java.util.LinkedList;
import java.util.Stack;

public class BST<Element extends Comparable<Element>> {

    private class Node{
        public Element element;
        public Node left, right;

        public Node(Element element){
            this.element = element;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Element element){
        root = add(root, element);
    }

    private Node add(Node node, Element element) {
        if (node == null){
            size++;
            return new Node(element);
        }
        if (element.compareTo(node.element) < 0)
            node.left = add(node.left, element);
        if (element.compareTo(node.element) > 0)
            node.right = add(node.right, element);
        return node;
    }

    public boolean contains(Element element){
        return contains(root, element);
    }

    private boolean contains(Node node, Element element) {
        if (node == null)
            return false;
        if (element.compareTo(node.element) == 0)
            return true;
        else if (element.compareTo(node.element) < 0)
            return contains(node.left, element);
        else
            return contains(node.right, element);
    }

    /**
     *  非递归前序遍历
     */
    public void perOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.element);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void preOrder(){
        perOrder(root);
    }

    private void perOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.element);
        perOrder(node.left);
        perOrder(node.right);
    }

    /**
     * 中序遍历会按序输出一颗二叉树
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    /**
     * 在手动释放内存时, 可以用到后序遍历. 先释放子节点,后释放根节点
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    public void levelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.element);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
    public void add(Element element){
        if (root == null){
            root = new Node(element);
            size++;
        } else {
            add(root, element);
        }
    }

    private void add(Node root, Element element) {
        if (element.equals(root.element)){
            return;
        } else if (element.compareTo(root.element) < 0 && root.left == null){
            root.left = new Node(element);
            size++;
            return;
        } else if (element.compareTo(root.element) > 0 && root.right == null){
            root.right = new Node(element);
            size++;
            return;
        }

        if (element.compareTo(root.element) < 0){
            add(root.left, element);
        } else {
            add(root.right, element);
        }
    }
    */

    public Element minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).element;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public Element maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).element;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    public Element removeMin(){
        Element ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public Element removeMax(){
        Element ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(Element element){
        root = remove(root, element);
    }

    private Node remove(Node node, Element element) {
        if (node == null){
            return null;
        }

        if (element.compareTo(node.left.element) < 0){
            node.left = remove(node.left, element);
            return node;
        } else if (element.compareTo(node.right.element) > 0){
            node.right = remove(node.right, element);
            return node;
        } else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            Node temp = node;
            node = minimum(temp.right);
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }
        size--;
        return node;
    }

}
