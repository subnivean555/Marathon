package leetcode.list;

public class Medium_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        int ex = 0;
        while (l1 != null || l2 != null){
            int addition = ((l1 == null)? 0 : l1.val) + ((l2 == null)? 0 : l2.val);
            if (ex > 0){
                addition += ex;
                ex = 0;
            }
            if (addition >= 10){
                ex = 1;
            }
            addition %= 10;
            dummy.next = new ListNode(addition);
            dummy = dummy.next;
            if (l1 == null){
                l1 = null;
            } else {
                l1 = l1.next;
            }
            if (l2 == null){
                l2 = null;
            } else {
                l2 = l2.next;
            }
        }
        if (ex != 0){
            dummy.next = new ListNode(ex);
        }
        return newHead.next;
    }

}
