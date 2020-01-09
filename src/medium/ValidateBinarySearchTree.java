package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class ValidateBinarySearchTree {

//    public boolean isValidBST(TreeNode root) {
//        return traversal(root, null, null);
//        return inOrder(root);
//    }

//    /**
//     * 主要思想是每个节点都会在一个区间范围内，超出这个区间范围就不合法了
//     * @param node
//     * @param min
//     * @param max
//     * @return
//     */
//    public boolean traversal(TreeNode node, Integer min, Integer max){
//        if (node == null) return true;
//        if (min != null && node.val <= min) return false;
//        if (max != null && node.val >= max) return false;
//        if (!traversal(node.left, min, node.val)) return false;
//        if (!traversal(node.right, node.val, max)) return false;
//        return true;
//    }

    /**
     * 由于二叉搜索树的特性，对树进行中序遍历，那么该顺序就是从小到大的顺序
     * @param node
     * @return
     */
//    public boolean inOrder(TreeNode node){
//        Stack<TreeNode> stack = new Stack<>();
//        Integer pre = null;
//        while (node != null || !stack.isEmpty()) {
//            //先按中顺遍历压栈
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            if (pre != null && pre >= node.val) return false;
//            pre = node.val;
//            node = node.right;
//        }
//        return true;
//    }

//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        _isValidBST(list, root);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) >= list.get(i + 1)) return false;
//        }
//        return true;
//    }
//
//
//    private void _isValidBST(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        _isValidBST(list, node.left);
//        list.add(node.val);
//        _isValidBST(list, node.right);
//    }

//    public boolean isValidBST(TreeNode root) {
//        return _isValidBST(root, null, null);
//    }
//
//    private boolean _isValidBST(TreeNode node, Integer min, Integer max){
//        if (node == null) return true;
//        if (min != null && node.val <= min) return false;
//        if (max != null && node.val >= max) return false;
//        if(!_isValidBST(node.left, min, node.val)) return false;
//        if(!_isValidBST(node.right, node.val, max)) return false;
//        return true;
//    }

    /**
     * 二叉搜索树的中序遍历是从小到大有序的数组
     * @param root
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        _traserval(list, root);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) <= list.get(i - 1)) return false;
//        }
//        return true;
//    }
//
//    private void _traserval(List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        _traserval(list, node.left);
//        list.add(node.val);
//        _traserval(list, node.right);
//    }

    private Integer value = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if(!isValidBST(root.left)) return false;
        if (value != null && root.val <= value) return false;
        value = root.val;
        return isValidBST(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
