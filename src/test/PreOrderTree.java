package test;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/12/26
 */
public class PreOrderTree {
    public void preOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                // 处理当前节点
                System.out.print(tmp.value);
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                TreeNode node = stack.pop();
                tmp = node.right;
            }
        }
    }

    public void inOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                TreeNode node = stack.pop();
                // 处理节点
                System.out.print(node.value);
                tmp = node.right;
            }
        }
    }


    public void postOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>(); // 进行辅助
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (node.left != null) stack.push(node.left);
            if (root.right != null) stack.push(node.right);
            list.add(node);
        }
        Collections.reverse(list);
        for (TreeNode t : list) {
            System.out.print(t.value);
        }
    }

    public void levelTraverse(TreeNode root) {
        // 层次遍历需要使用队列进行实现
        Deque<TreeNode> deque = new LinkedList<>();
        // 初始化
        deque.addLast(root);
        // 进行遍历
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.removeFirst();
                if (node == null) continue;
                System.out.print(node.value);
                deque.addLast(node.left);
                deque.addLast(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        d.left = f;
        d.right = g;
        PreOrderTree p = new PreOrderTree();
        p.postOrderTraverse(root);
    }
}
