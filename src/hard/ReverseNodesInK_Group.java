package hard;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class ReverseNodesInK_Group {

//    public ListNode reverseKGroup(ListNode head, int k) {
//        int count = 0;
//        ListNode tmp = head;
//        //找出k+1的节点
//        while (tmp != null && count != k) {
//            tmp = tmp.next;
//            count++;
//        }
//        if (count == k) {
//            //迭代节点
//            ListNode re = reverseKGroup(tmp, k);
//            //进行交换
//            while (count-- > 0){
//                tmp = head.next;
//                head.next = re;
//                re = head;
//                head = tmp;
//            }
//            head = re;
//        }
//        return head;
//    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (k == 0 || k == 1) return head;
//        int count = 0;
//        ListNode tmp = head;
//        while (tmp != null && count != k){
//            tmp = tmp.next;
//            count++;
//        }
//        if (count == k) {
//            ListNode last = reverseKGroup(tmp, k);
//            while (count-- > 0) {
//               tmp = head.next;
//               head.next = last;
//               last = head;
//               head = tmp;
//            }
//            head = last;
//        }
//        return head;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        return reserval(head, k);
    }

    private ListNode reserval(ListNode node, int k) {
        Map<String, Object> map = isEnoughLength(node, k);
        ListNode end = (ListNode) map.get("data");
        if (!(Boolean) map.get("flag")) return end;
        ListNode next = node.next;
        ListNode tmp = reserval(end, k);
        ListNode newhead = _reserval(node, k);
        next.next = node;
        node.next = tmp;
        return newhead;
    }

    private ListNode _reserval(ListNode node, int k) {
        if (k == 1) { return node; }
        ListNode tmp = node.next;
        ListNode newHead = _reserval(node.next, k - 1);
        node.next = null;
        tmp.next = node;
        return newHead;
    }

    private Map<String, Object> isEnoughLength(ListNode node, int k) {
        Map<String, Object> map = new HashMap<>();
        ListNode tmp = node;
        while (k > 0 && tmp != null) {
            k--;
            tmp = tmp.next;
        }
        if (k != 0) {
            map.put("flag", false);
            map.put("data", node);
        } else {
            map.put("flag", true);
            map.put("data", tmp);
        }
        return map;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReverseNodesInK_Group g = new ReverseNodesInK_Group();
        g.reverseKGroup(head, 2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
