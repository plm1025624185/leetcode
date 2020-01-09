package easy;

/**
 * @author 潘磊明
 * @date 2019/10/21
 */
public class LinkedListCycle {

//    public boolean hasCycle(ListNode head) {
//        if (head == null) return false;
//        //快慢节点求解
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast.next != null && fast.next.next != null && slow.next != null) {
//            if (fast.next.next == slow.next) {
//                return true;
//            }
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return false;
//    }

//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) return false;
//        ListNode slow = head;
//        ListNode fast = head;
//        do {
//            slow = slow.next;
//            fast = fast.next.next;
//        } while (slow != null && fast != null && fast.next != null && slow != fast);
//        return slow == fast;
//    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
