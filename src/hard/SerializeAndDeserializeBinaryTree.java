package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * @author 潘磊明
 * @date 2019/10/24
 */
public class SerializeAndDeserializeBinaryTree {
//    private String non = "NULL"; //空节点字符串
//    private String spliter = ",";
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        StringBuilder data = new StringBuilder();
//        _serialize(root, data);
//        return data.toString();
//    }
//
//    public void _serialize(TreeNode node, StringBuilder data){
//        if (node == null){
//            data.append(non);
//            data.append(spliter);
//        } else {
//            data.append(node.val);
//            data.append(spliter);
//            _serialize(node.left, data);
//            _serialize(node.right, data);
//        }
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        Deque<String> queue = new LinkedList<>();
//        queue.addAll(Arrays.asList(data.split(",")));
//        return _deserialize(queue);
//    }
//
//    public TreeNode _deserialize(Deque<String> queue){
//        if (queue.size() == 0) return null;
//        String val = queue.remove();
//        if (non.equals(val)) return null;
//        TreeNode node = new TreeNode(Integer.parseInt(val));
//        node.left = _deserialize(queue);
//        node.right = _deserialize(queue);
//        return node;
//    }


//    private String EMPTY_STR = "NULL";
//    private String SPLIT_CHARACTER = ",";
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        _serialize(sb, root);
//        return sb.substring(0, sb.length() - 1).toString();
//    }
//
//    private void _serialize(StringBuilder sb, TreeNode node){
//        if (node == null) {sb.append(EMPTY_STR); sb.append(SPLIT_CHARACTER);}
//        else {
//            sb.append(node.val);
//            sb.append(SPLIT_CHARACTER);
//            _serialize(sb, node.left);
//            _serialize(sb, node.right);
//        }
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String[] d = data.split(SPLIT_CHARACTER);
//        Deque<String> deque = new LinkedList<>();
//        deque.addAll(Arrays.asList(d));
//        return _deserialize(deque);
//    }
//
//    private TreeNode _deserialize(Deque<String> deque) {
//        if (deque.isEmpty()) return null;
//        String s = deque.removeFirst();
//        if (EMPTY_STR.equals(s)) return null;
//        TreeNode node = new TreeNode(Integer.parseInt(s));
//        node.left = _deserialize(deque);
//        node.right = _deserialize(deque);
//        return node;
//    }

    private String NULL_STRING = "null";
    private String SPLITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.removeFirst();
                if (node == null) sb.append(NULL_STRING);
                else {
                    sb.append(node.val);
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
                sb.append(SPLITER);
            }
        }
        return sb.substring(0, sb.length());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<TreeNode> deque = new LinkedList<>();
        String[] dataArray = data.split(SPLITER);
        int i = 0;
        TreeNode root = transform(dataArray[i++]);
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if (node == null) continue;
            if (i < dataArray.length) {
                node.left = transform(dataArray[i]);
                deque.addLast(node.left);
                i++;
            }
            if (i < dataArray.length) {
                node.right = transform(dataArray[i]);
                deque.addLast(node.right);
                i++;
            }
        }
        return root;
    }

    private TreeNode transform(String val) {
        if (NULL_STRING.equals(val)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(val));
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        String s = "1,2,3,null,null,4,5";
        SerializeAndDeserializeBinaryTree ss = new SerializeAndDeserializeBinaryTree();
        TreeNode treeNode = ss.deserialize(s);
        System.out.print(111);
    }
}
