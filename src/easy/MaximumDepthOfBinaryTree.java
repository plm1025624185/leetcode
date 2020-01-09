package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/24
 */
public class MaximumDepthOfBinaryTree {

//    public int maxDepth(TreeNode root) {
//        return traserval(root, 0);
//    }
//
//    public int traserval(TreeNode node, int level){
//        if (node == null) return level;
//        int left = traserval(node.left, level + 1);
//        int right = traserval(node.right, level + 1);
//        return Math.max(left, right);
//    }

//    public int maxDepth(TreeNode root) {
//        return _maxDepth(root, 1);
//    }
//
//    private int _maxDepth(TreeNode node, int depth){
//        if (node == null) return depth - 1;
//        int left = _maxDepth(node.left, depth + 1);
//        int right = _maxDepth(node.right, depth + 1);
//        return Math.max(left, right);
//    }

//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.addLast(root);
//        int max = 0;
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            while(size-- > 0) {
//                TreeNode node = deque.removeFirst();
//                if (node.left != null) deque.addLast(node.left);
//                if (node.right != null) deque.addLast(node.right);
//            }
//            max++;
//        }
//        return max;
//    }

//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int level = 0;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.addLast(root);
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            if (size > 0) level++;
//            while (size-- > 0) {
//                TreeNode node = deque.removeFirst();
//                if (node.left != null) deque.addLast(node.left);
//                if (node.right != null) deque.addLast(node.right);
//            }
//        }
//        return level;
//    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
