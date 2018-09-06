package algoAndStructure.linkedList;

public class LinkedListQueue<Element> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Element value){
        if (tail == null){
            tail = new Node(value);
            head = tail;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    public Element dequeue(){
        if (isEmpty())
            throw new IllegalArgumentException("cant dequeue from an empty queue");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;
        return retNode.value;
    }

    public Element getFront(){
        if (isEmpty())
            throw new IllegalArgumentException("queue is empty");
        return head.value;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue : from");
        Node cur = head;
        while (cur != null){
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
