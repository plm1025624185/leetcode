package easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class N_aryTreePreorderTraversal {

//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }
//
//    public void traversal(Node root, List<Integer> list){
//        if (root != null) {
//            list.add(root.val);
//            for (Node node : root.children) {
//                traversal(node, list);
//            }
//        }
//    }

//    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        _traversal(result, root);
//        return result;
//    }
//
//    private void _traversal(List<Integer> list, Node node){
//        if (node == null) return;
//        list.add(node.val);
//        for (Node child : node.children) _traversal(list, child);
//    }

//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        _preorder(list, root);
//        return list;
//    }
//
//    private void _preorder(List<Integer> list, Node node) {
//        if (node == null) return;
//        list.add(node.val);
//        for (Node n : node.children) {
//            _preorder(list, n);
//        }
//    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
            if (node == null) continue;
            list.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                deque.addFirst(children.get(i));
            }
        }
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
