package medium;

import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class SwapNodesInPairs {

//    public ListNode swapPairs(ListNode head) {
//        if (head == null) return head;
//        ListNode newHead = new ListNode(0); //哨兵节点用于占位
//        swapNode(newHead, head);
//        return newHead.next;
//    }
//
//    public void swapNode(ListNode head, ListNode swapNode){
//        if (swapNode != null && swapNode.next != null) {
//            ListNode tmp = swapNode.next.next;
//            head.next = swapNode.next;
//            head.next.next = swapNode;
//            swapNode = tmp;
//            swapNode(head.next.next, swapNode);
//        }else{
//            head.next = swapNode;
//        }
//    }

//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode nextNode = swapPairs(head.next.next);
//        ListNode first = head.next;
//        first.next = head;
//        head.next = nextNode;
//        return first;
//    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next.next;
        ListNode newHead = swapPairs(tmp);
        ListNode node = head.next;
        node.next = head;
        head.next = newHead;
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
