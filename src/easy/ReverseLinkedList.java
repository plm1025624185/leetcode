package easy;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class ReverseLinkedList {
    /**
     * 对链表进行迭代
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = null;
//        while (head != null) {
//            ListNode tmp = head;
//            head = head.next;
//            tmp.next = newHead;
//            newHead = tmp;
//        }
//        return newHead;
//    }

    /**
     * 递归
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        return head ==null ? head : reverseNode(head, null);
//    }
//
//    public ListNode reverseNode(ListNode src, ListNode dest){
//        ListNode tmp = null;
//        tmp = src;
//        src = src.next;
//        tmp.next = dest;
//        if (src != null) {
//            return reverseNode(src, tmp);
//        }else{
//            return tmp;
//        }
//    }

//    public ListNode reverseList(ListNode head) {
//        return head == null ? head : reverse(head, null);
//    }
//
//    private ListNode reverse(ListNode src, ListNode dest) {
//        ListNode tmp = src;
//        src = src.next;
//        tmp.next = dest;
//        if (src != null) {
//            return reverse(src, tmp);
//        } else {
//            return tmp;
//        }
//    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null) return head;
//        ListNode newHead = new ListNode(0);
//        while (head != null) {
//            ListNode tmp = head;
//            head = head.next;
//            tmp.next = newHead.next;
//            newHead.next = tmp;
//        }
//        return newHead.next;
//    }

//    public ListNode reverseList(ListNode head) {
//        if(head==null || head.next==null)
//            return head;
//        ListNode nextNode=head.next;
//        ListNode newHead=reverseList(nextNode);
//        nextNode.next=head;
//        head.next=null;
//        return newHead;
//    }

    /**
     * 使用迭代
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        if(head == null) return head;
//        Deque<ListNode> deque = new LinkedList<>();
//        while (head != null) {
//            ListNode tmp = head.next;
//            head.next = null;
//            deque.addFirst(head);
//            head = tmp;
//        }
//        head = deque.removeFirst();
//        ListNode tmp = head;
//        while (!deque.isEmpty()) {
//            tmp.next = deque.removeFirst();
//            tmp = tmp.next;
//        }
//        return head;
//    }


    /**
     * 使用递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newhead = reverseList(next);
        next.next = head;
        head.next = null;
        return newhead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList l = new ReverseLinkedList();
        ListNode root = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        ListNode r5 = new ListNode(5);
        root.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        l.reverseList(root);
    }

}