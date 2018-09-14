package structure.map;

import java.util.NoSuchElementException;

/**
 *  使用 二叉树来实现 Map
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchMap<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
    public BinarySearchMap(){}
    
    public boolean isEmpty(){
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null){
            return 0;
        } else {
            return node.size;
        }
    }

    private void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = delete(node.left, key);
        }else if (cmp > 0){
            node.right = delete(node.right, key);
        } else {
            if (node.right == null){
                return node.left;
            }
            if (node.left == null){
                return node.right;
            }
            Node temp = node;
            temp = min(temp.right);
            temp.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 删除最小节点
     */
    public void deleteMin(){
        if (isEmpty())
            throw new NoSuchElementException();
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min(){
        if (isEmpty())
            throw new NoSuchElementException("");
        return min(root).key;
    }

    /**
     *  返回最小节点
     *  如果左节点为空, 那么返回自己, 如果左节点不为空, 那么返回左节点
     * @param node
     * @return
     */
    private Node min(Node node) {
        if (node.left == null){
            return node;
        }else {
            return min(node.left);
        }
    }

    public Key max(){
        if (isEmpty())
            throw new NoSuchElementException("");
        return max(root).key;
    }

    /**
     *  返回最大节点
     *  如果右节点为空, 那么返回自己, 如果右节点不为空, 那么返回右节点
     * @param node
     * @return
     */
    private Node max(Node node) {
        if (node.right == null){
            return node;
        }else {
            return min(node.right);
        }
    }

    public void put(Key key, Value val){
        if (key == null)
            throw new IllegalArgumentException("calls put() with a null key");
        if (val == null){
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    /**
     *  向 BST 中插入一个新的节点
     *  如果该节点值比当前节点小, 那么和该节点的左子树比较
     *  如果该节点值比当前节点大, 那么和该节点的右子树比较
     *  如果与该节点相等, 那么对该节点的值进行更新
     *  如果当前为空树, 则返回一个新的节点作为根节点
     * @param node
     * @param key
     * @param val
     * @return
     */
    private Node put(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = put(node.left, key, val);
        } else if (cmp > 0){
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(Key key){
        return get(root, key);
    }

    /**
     *  通过 key 来查找 BST 中的 val
     *  如果当前树为空, 返回 null
     *  如果当前节点的 key 比指定 key 大, 那么查找当前节点的右子树
     *  如果当前节点的 key 比指定 key 小, 那么查找当前节点的左子树
     *  否则返回当前节点的 val
     * @param node
     * @param key
     * @return
     */
    private Value get(Node node, Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls get() with a null key");
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return get(node.left, key);
        }  else if (cmp > 0){
            return get(node.right, key);
        } else {
            return node.val;
        }
    }

    public boolean contains(Key key){
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }


    public static void main(String[] args) {


    }
}
