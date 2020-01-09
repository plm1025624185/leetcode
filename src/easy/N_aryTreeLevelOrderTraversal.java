package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class N_aryTreeLevelOrderTraversal {

//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (root != null){
//            list.add(Arrays.asList(root.val));
//            traversal(root.children, list);
//        }
//        return list;
//    }
//
//    public void traversal(List<Node> nodes, List<List<Integer>> list){
//        if (nodes.size() > 0) {
//            List<Integer> vals = new ArrayList<>(nodes.size());
//            List<Node> children = new ArrayList<>();
//            for (Node node : nodes) {
//                vals.add(node.val);
//                if (node.children != null) {
//                    children.addAll(node.children);
//                }
//            }
//            list.add(vals);
//            traversal(children, list);
//        }
//    }

    /**
     * 使用递归
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null) return Collections.emptyList();
//        List<List<Integer>> result = new ArrayList<>();
//        _levelOrder(result, Arrays.asList(root));
//        return result;
//    }
//
//    private void _levelOrder(List<List<Integer>> result, List<Node> list) {
//        if (list.size() == 0) return;
//        List<Node> children = new ArrayList<>();
//        List<Integer> values = new ArrayList<>();
//        for(Node node : list) {
//            if (node == null) continue;
//            values.add(node.val);
//            if (node.children != null) children.addAll(node.children);
//        }
//        result.add(values);
//        _levelOrder(result, children);
//    }

    /**
     * 使用队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>(size);
            while (size-- > 0) {
                Node first = deque.removeFirst();
                if (first == null) continue;
                list.add(first.val);
                deque.addAll(first.children);
            }
            result.add(list);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
