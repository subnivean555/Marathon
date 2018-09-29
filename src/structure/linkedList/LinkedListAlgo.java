package structure.linkedList;

import java.util.Arrays;
import java.util.List;

public class LinkedListAlgo {

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

    /**
     *  使用循环的方式反转链表
     * @param head
     * @return
     */
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

    /**
     *  删除链表中, value 与传入参数相同的节点, 并返回删除后的头节点
     * @param head
     * @param value
     * @return
     */
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

    /**
     *  删除倒数第 N 个节点
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEnd(Node head, int n){
        if (head == null)
            return null;
        Node newHead = new Node(-1);
        newHead.setNext(head);
        Node quicker = head, slower = newHead;

        while (n-- > 0){
            quicker = quicker.getNext();
        }
        while (quicker != null){
            slower = slower.getNext();
            quicker = quicker.getNext();
        }

        slower.setNext(slower.getNext().getNext());
        return newHead.getNext();
    }

    /**
     *  使用递归的方法来将两个有序链表合并为一个有序链表
     * @param list
     * @param list2
     * @return
     */
    public static Node mergeTwoLists(Node list, Node list2){
        if (list == null){
            return list2;
        }
        if (list2 == null){
            return list;
        }
        if (list.getValue() < list2.getValue()){
            list.setNext(mergeTwoLists(list.getNext(), list2));
            return list;
        } else {
            list2.setNext(mergeTwoLists(list, list2.getNext()));
            return list2;
        }
    }

    /**
     *  使用循环的方式来将两个有序链表合并为一个有序链表
     * @param list
     * @param list2
     * @return
     */
    public static Node mergeTwoLists2(Node list, Node list2){
        Node head = null;
        if (list == null){
            return list2;
        } else if (list2 == null){
            return list;
        } else if (list.getValue() <= list2.getValue()){
            head = list;
            list = list.getNext();
        } else {
            head = list2;
            list2 = list2.getNext();
        }

        Node tmp = head;
        while (list != null && list2 != null){
            if (list.getValue() <= list2.getValue()){
                tmp.setNext(list);
                list = list.getNext();
            } else {
                tmp.setNext(list2);
                list2 = list2.getNext();
            }
            tmp = tmp.getNext();
        }

        if (list != null)
            tmp.setNext(list2);
        if (list2 != null)
            tmp.setNext(list2);
        return head;
    }

    /**
     *  判断是否为回文链表
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head) {
        if (head == null)
            return true;
        Node mid = getMiddle(head);
        Node rev = reverseLinkedList2(mid);

        while (rev != null){
            if (rev.getValue() == head.getValue()){
                System.out.println(head.getValue());
                rev = rev.getNext();
                head = head.getNext();
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     *  获取链表的中间元素
     * @param head
     * @return
     */
    public static Node getMiddle(Node head) {
        if (head == null)
            return null;
        Node fast = head.getNext(), slow = head;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getNext();
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

    /**
     *  判断链表是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle(Node head) {
        if (head == null){
            return false;
        }
        Node fast = head, slow = head;
        while (fast.getNext() != null){
            if (fast == slow){
                return true;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return !(fast == null || fast.getNext() == null);
    }


    public static void main(String[] args) {

        Node list = createLinkedList(Arrays.asList(1,2));
        System.out.println(isPalindrome(list));

        /*
        Node list = createLinkedList(Arrays.asList(1,2,4));
        Node list2 = createLinkedList(Arrays.asList(3,4,5));
        printLinkedList(mergeTwoLists(list, list2));
        printLinkedList(removeNthFromEnd(node, 1));
        printLinkedList(createLinkedList(Arrays.asList(1)));
        printLinkedList(createLinkedList(Arrays.asList()));
        printLinkedList(reverseLinkedList(createLinkedList(Arrays.asList(1,2,3,4,5,6,7))));
        printLinkedList(reverseLinkedList2(createLargeLinkedList(100)));
        */
    }
}
