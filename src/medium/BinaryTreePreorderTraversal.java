package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class BinaryTreePreorderTraversal {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }
//
//    public void traversal(TreeNode node, List<Integer> list){
//        if (node != null) {
//            list.add(node.val);
//            traversal(node.left, list);
//            traversal(node.right, list);
//        }
//    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        _traversal(result, root);
//        return result;
//    }
//
//    private void _traversal(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        list.add(node.val);
//        _traversal(list, node.left);
//        _traversal(list, node.right);
//    }

//    /**
//     * 使用循环
//     * @param root
//     * @return
//     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        Deque<TreeNode> deque = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        TreeNode cur = root;
//        while (cur != null || !deque.isEmpty()) {
//            while (cur != null) {
//                list.add(cur.val);
//                deque.addFirst(cur);
//                cur = cur.left;
//            }
//            cur = deque.removeFirst().right;
//        }
//        return list;
//    }

    /**
     * 使用递归
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        _preorderTraversal(list, root);
//        return list;
//    }
//
//    private void _preorderTraversal(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        list.add(node.val);
//        _preorderTraversal(list, node.left);
//        _preorderTraversal(list, node.right);
//    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            if (node != null) {
                deque.addFirst(node);
                list.add(node.val);
                node = node.left;
            } else {
                TreeNode tmp = deque.removeFirst();
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
