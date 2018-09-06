package algoAndStructure.linkedList;

/**
 *  添加操作
 *      addFirst(Element)   O(1)
 *      addLast(Element)    O(n)
 *      add(index, element) O(n)
 *
 *      removeLast(element) O(n)
 *      removeFirst(element) O(1)
 *      remove(element)     O(n)
 *
 *      get(index)          O(n)
 *      contains(element)   O(n)
 * @param <Element>
 */

public class MyLinkedList<Element> {

    private class Node{
        public Element value;
        public Node next;

        public Node(Element value, Node next){
            this.value = value;
            this.next = next;
        }

        public Node(Element value){
            this(value, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node dummyhead;
    private int size;

    public MyLinkedList(){
        dummyhead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, Element value){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed. Illegal index");
        }

        Node prev = dummyhead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(value, prev.next);
        size++;

    }

    public void addFirst(Element value){
        add(0, value);
    }

    public void addLast(Element value){
        add(size, value);
    }

    public Element get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed. Illegal index");
        }

        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.value;
    }

    public Element getFirst(){
        return get(0);
    }

    public Element getLast(){
        return get(size - 1);
    }

    public void set(int index, Element value){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed. Illegal index");
        }

        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.value = value;
    }

    public boolean contains(Element value){
        Node cur = dummyhead.next;
        while (cur != null){
            if (cur.value == value){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public Element remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed. Illegal index");
        }

        Node prev = dummyhead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.value;
    }

    public Element removeFirst(){
        return remove(0);
    }

    public Element removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyhead.next;

        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        for (int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 55);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(55));
        linkedList.set(4, 10);
        System.out.println(linkedList);
    }
}
