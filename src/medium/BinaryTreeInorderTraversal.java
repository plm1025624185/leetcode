package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class BinaryTreeInorderTraversal {

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }
//
//    public void traversal(TreeNode node, List<Integer> list){
//        if (node != null) {
//            traversal(node.left, list);
//            list.add(node.val);
//            traversal(node.right, list);
//        }
//    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(list, root);
//        return list;
//    }
//
//    private void traversal(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        traversal(list, node.left);
//        list.add(node.val);
//        traversal(list, node.right);
//    }

    /**
     * 迭代的方式
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root){
//        Deque<TreeNode> deque = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        TreeNode cur = root;
//        while (cur != null || !deque.isEmpty()) {
//            while (cur != null) {
//                deque.addFirst(cur);
//                cur = cur.left;
//            }
//            cur = deque.removeFirst();
//            list.add(cur.val);
//            cur = cur.right;
//        }
//        return list;
//    }

    /**
     * 中序遍历使用递归
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        _inorderTraversal(list, root);
//        return list;
//    }
//
//    private void _inorderTraversal(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        _inorderTraversal(list, node.left);
//        list.add(node.val);
//        _inorderTraversal(list, node.right);
//    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            if (node != null) {
                deque.addFirst(node);
                node = node.left;
            } else {
                TreeNode tmp = deque.removeFirst();
                list.add(tmp.val);
                node = tmp.right;
            }
        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
