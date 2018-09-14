package structure.map;

public class LinkedListMap<Key, Value> {

    private class Node{
        public Key key;
        public Value val;
        public Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public Node(Key key){
            this(key, null, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + val.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private Node getNode(Key key){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public boolean contains(Key key){
        return getNode(key) != null;
    }

    public Value get(Key key){
        Node node = getNode(key);
        return node == null ? null : node.val;
    }

    public void add(Key key, Value value){
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.val = value;
        }
    }

    public void set(Key key, Value newVal){
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist !");
        node.val = newVal;
    }

    public Value remove(Key key){

        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.val;
        }
        return null;
    }

}
