package medium;

import easy.MaximumDepthOfBinaryTree;

import javax.naming.Name;

/**
 * @author 潘磊明
 * @date 2019/10/20
 */
public class DesignCircularDeque {
//    private int length; //最大的长度
//    private int size; //当前的节点数
//    private Node head; //头部节点
//    private Node tail; //尾结点
//
//    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public DesignCircularDeque(int k) {
//        length = k;
//        size = 0;
//        head = new Node(Integer.MIN_VALUE);
//        tail = new Node(Integer.MAX_VALUE);
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    /** Adds an item at the front of Deque. Return true if the operation is successful. */
//    public boolean insertFront(int value) {
//        if(isFull()) return false;
//        Node node = new Node(value);
//        Node tmp = head.next;
//        tmp.prev = node;
//        head.next = node;
//        node.prev = head;
//        node.next = tmp;
//        size++;
//        return true;
//    }
//
//    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//    public boolean insertLast(int value) {
//        if(isFull()) return false;
//        Node node = new Node(value);
//        Node tmp = tail.prev;
//        tmp.next = node;
//        node.prev = tmp;
//        node.next = tail;
//        tail.prev = node;
//        size++;
//        return true;
//    }
//
//    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//    public boolean deleteFront() {
//        if(isEmpty()) return false;
//        head.next = head.next.next;
//        head.next.prev = head;
//        size--;
//        return true;
//    }
//
//    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//    public boolean deleteLast() {
//        if(isEmpty()) return false;
//        tail.prev = tail.prev.prev;
//        tail.prev.next = tail;
//        size--;
//        return true;
//    }
//
//    /** Get the front item from the deque. */
//    public int getFront() {
//        if(isEmpty()) return -1;
//        return head.next.value;
//    }
//
//    /** Get the last item from the deque. */
//    public int getRear() {
//        if(isEmpty()) return -1;
//        return tail.prev.value;
//    }
//
//    /** Checks whether the circular deque is empty or not. */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /** Checks whether the circular deque is full or not. */
//    public boolean isFull() {
//        return size == length;
//    }
//
//    private class Node{
//        Node prev;
//        Node next;
//        int value;
//
//        private Node(int value){
//            this.value = value;
//        }
//    }

//    private int size;
//    private int maxLength;
//    private Node head;
//
//
//    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public DesignCircularDeque(int k) {
//        this.size = 0;
//        this.maxLength = k;
//        this.head = new Node(Integer.MAX_VALUE);
//        head.next = head;
//        head.prev = head;
//    }
//
//    /** Adds an item at the front of Deque. Return true if the operation is successful. */
//    public boolean insertFront(int value) {
//        if (isFull()) return false;
//        Node node = new Node(value);
//        Node tmp = head.next;
//        tmp.prev = node;
//        node.next =tmp;
//        head.next = node;
//        node.prev = head;
//        size++;
//        return true;
//    }
//
//    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//    public boolean insertLast(int value) {
//        if (isFull()) return false;
//        Node node = new Node(value);
//        Node tmp = head.prev;
//        tmp.next = node;
//        node.prev = tmp;
//        node.next = head;
//        head.prev = node;
//        size++;
//        return true;
//    }
//
//    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//    public boolean deleteFront() {
//        if (isEmpty()) return false;
//        head.next = head.next.next;
//        head.next.prev = head;
//        size--;
//        return true;
//    }
//
//    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//    public boolean deleteLast() {
//        if (isEmpty()) return false;
//        head.prev = head.prev.prev;
//        head.prev.next = head;
//        size--;
//        return true;
//    }
//
//    /** Get the front item from the deque. */
//    public int getFront() {
//        if (isEmpty()) return -1;
//        return head.next.value;
//    }
//
//    /** Get the last item from the deque. */
//    public int getRear() {
//        if (isEmpty()) return -1;
//        return head.prev.value;
//    }
//
//    /** Checks whether the circular deque is empty or not. */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /** Checks whether the circular deque is full or not. */
//    public boolean isFull() {
//        return size == maxLength;
//    }

    private int maxSize;
    private int size;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        maxSize = k;
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node node = head.next.next;
        head.next = node;
        node.prev = head;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node node = tail.prev.prev;
        node.next = tail;
        tail.prev = node;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }

    class Node {
        private Node prev;
        private Node next;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }
}
