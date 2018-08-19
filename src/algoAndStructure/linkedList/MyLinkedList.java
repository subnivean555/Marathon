package algoAndStructure.linkedList;

import java.util.Arrays;
import java.util.List;

public class MyLinkedList {

    /**
     *  将数组转为一个链表
     * @param datas
     * @return
     */
    public static Node createLinkedList(List<Integer> datas){
        if (datas.isEmpty()){
            return null;
        }
        Node firstNode = new Node(datas.get(0));
        Node headOfSublist = createLinkedList(datas.subList(1, datas.size()));
        firstNode.setNext(headOfSublist);
        return firstNode;
    }

    /**
     *  打印链表
     * @param head
     */
    public static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.getValue()+" ");
            head = head.getNext();
        }
        System.out.println();
    }

    /**
     * 使用递归反转链表, 递归操作的效率并不高, 需要反复的压栈.
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head){
        if (head == null || head.getNext() == null){
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static Node reverseLinkedList2(Node head){
        Node newHead = null, curHead = head;
        while (curHead != null){
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }


    public static Node deleteIfEquals(Node head, int value){
        while (head != null && head.getValue() == value){
            head = head.getNext();
        }
        if (head == null){
            return null;
        }

        Node prev = head;

        while (prev.getNext() != null){
            if (prev.getNext().getValue() == value){
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return head;
    }

    public static Node createLargeLinkedList(int size){
        Node prev = null;
        Node head = null;
        for (int i = 1; i <= size; i++){
            Node node = new Node(i);
            if (prev != null){
                prev.setNext(node);
            } else {
                head = node;
            }
            prev = node;
        }
        return head;
    }

    public static void main(String[] args) {
        printLinkedList(createLinkedList(Arrays.asList(1)));
        printLinkedList(createLinkedList(Arrays.asList()));
        printLinkedList(reverseLinkedList(createLinkedList(Arrays.asList(1,2,3,4,5,6,7))));
        printLinkedList(reverseLinkedList2(createLargeLinkedList(100)));
    }
}
