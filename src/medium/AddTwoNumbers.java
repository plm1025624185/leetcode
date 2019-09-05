package medium;

/**
 * 有两个非空链表，且它们的元素否是非负的，数字按逆序进行排序，并且每个节点存储一个数字。
 * 将这两个数相加并返回一个链表
 */
public class AddTwoNumbers {

    public ListNode solutionOne(ListNode l1, ListNode l2) {
        int needAdd = 0;// 用于进位计数
        ListNode node = null;
        ListNode tmpNode = null;
        do{
            int tmp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + needAdd;
            needAdd = 0;
            if(tmp >= 10){
                needAdd = 1;
                tmp = tmp - 10;
            }
            if(node == null){
                tmpNode = node = new ListNode(tmp);
            }else{
                tmpNode.next = new ListNode(tmp);
                tmpNode = tmpNode.next;
            }
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }while(l1 != null && l2 != null && needAdd != 0);
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
