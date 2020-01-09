package easy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class MinStack {
//    Node head; //头结点
//    int min;
//    /** initialize your data structure here. */
//    public MinStack() {
//        head = new Node(Integer.MAX_VALUE);
//        min = head.val;
//    }
//
//    public void push(int x) {
//        Node tmp = new Node(x);
//        if (x <= min) {
//            Node minNode = new Node(min);
//            minNode.next = head.next;
//            head.next = minNode;
//            min = x;
//        }
//        tmp.next = head.next;
//        head.next = tmp;
//    }
//
//    public void pop() {
//        if (head.next != null) {
//           if (head.next.val == min) {
//               min = head.next.next.val;
//               head.next = head.next.next.next;
//           }else {
//               head.next = head.next.next;
//           }
//        }
//    }
//
//    public int top() {
//        return head.next.val;
//    }
//
//    public int getMin() {
//        return min;
//    }
//    private Node head;
//    private int min;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        head = new Node(Integer.MAX_VALUE);
//        min = Integer.MAX_VALUE;
//        head.minVal = min;
//    }
//
//    public void push(int x) {
//        Node n = new Node(x);
//        if (x < min) {
//            min = x;
//        }
//        n.minVal = min;
//        Node tmp = head.next;
//        head.next = n;
//        n.next = tmp;
//    }
//
//    public void pop() {
//        Node tmp = head.next;
//        head.next = tmp.next;
//        if (tmp.val == min) {
//            if (head.next != null) min = head.next.minVal;
//            else min = Integer.MAX_VALUE;
//        }
//    }
//
//    public int top() {
//        return head.next.val;
//    }
//
//    public int getMin() {
//        return min;
//    }
//
//    class Node {
//        int val;
//        int minVal;
//        Node next;
//
//        Node (int val) {
//            this.val = val;
//        }
//    }

    private Node head;
    private Node minHead;
    private int size;

    public MinStack() {
        head = new Node();
        minHead = new Node();
        size = 0;
    }

    public void push(int x) {
        Node node = new Node(x);
        Node min;
        if (size == 0) {
            min = new Node(x);
        } else {
            Node tmp = head.next;
            Node minNode = minHead.next;
            if (x > minNode.value) min = new Node(minNode.value);
            else min = new Node(x);
            node.next = tmp;
            min.next = minNode;
        }
        minHead.next = min;
        head.next = node;
        size++;
    }

    public void pop() {
        Node node = head.next;
        Node minNode = minHead.next;
        head.next = node.next;
        minHead.next = minNode.next;
        size--;
    }

    public int top() {
        return head.next.value;
    }

    public int getMin() {
        return minHead.next.value;
    }

    class Node {
        private int value;
        private Node next;

        Node(){}

        Node(int value){
            this.value = value;
        }
    }
}
