package hard;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/10/22
 */
public class ReverseNodesInK_Group {

//    public ListNode reverseKGroup(ListNode head, int k) {
//        int count = 0;
//        ListNode tmp = head;
//        //找出k+1的节点
//        while (tmp != null && count != k) {
//            tmp = tmp.next;
//            count++;
//        }
//        if (count == k) {
//            //迭代节点
//            ListNode re = reverseKGroup(tmp, k);
//            //进行交换
//            while (count-- > 0){
//                tmp = head.next;
//                head.next = re;
//                re = head;
//                head = tmp;
//            }
//            head = re;
//        }
//        return head;
//    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (k == 0 || k == 1) return head;
//        int count = 0;
//        ListNode tmp = head;
//        while (tmp != null && count != k){
//            tmp = tmp.next;
//            count++;
//        }
//        if (count == k) {
//            ListNode last = reverseKGroup(tmp, k);
//            while (count-- > 0) {
//               tmp = head.next;
//               head.next = last;
//               last = head;
//               head = tmp;
//            }
//            head = last;
//        }
//        return head;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        return reserval(head, k);
    }

    private ListNode reserval(ListNode node, int k) {
        Map<String, Object> map = isEnoughLength(node, k);
        ListNode end = (ListNode) map.get("data");
        if (!(Boolean) map.get("flag")) return end;
        ListNode next = node.next;
        ListNode tmp = reserval(end, k);
        ListNode newhead = _reserval(node, k);
        next.next = node;
        node.next = tmp;
        return newhead;
    }

    private ListNode _reserval(ListNode node, int k) {
        if (k == 1) { return node; }
        ListNode tmp = node.next;
        ListNode newHead = _reserval(node.next, k - 1);
        node.next = null;
        tmp.next = node;
        return newHead;
    }

    private Map<String, Object> isEnoughLength(ListNode node, int k) {
        Map<String, Object> map = new HashMap<>();
        ListNode tmp = node;
        while (k > 0 && tmp != null) {
            k--;
            tmp = tmp.next;
        }
        if (k != 0) {
            map.put("flag", false);
            map.put("data", node);
        } else {
            map.put("flag", true);
            map.put("data", tmp);
        }
        return map;
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        head.next = dfs(head.next, set);
        return head;
    }

    private ListNode dfs(ListNode node, Set<Integer> set) {
        if (node == null) return node;
        if (set.contains(node.val)) {
            return dfs(node.next, set);
        } else {
            set.add(node.val);
            node.next = dfs(node.next, set);
            return node;
        }
    }

    public int kthToLast(ListNode head, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.addFirst(head.val);
            head = head.next;
        }
        return deque.get(k - 1);
    }

    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int level = grid[i][j];
                if (level > 0) {
                    area += 2 + (level << 2);
                    area -= i > 0 ? Math.min(grid[i - 1][j], level) << 1 : 0;
                    area -= j > 0 ? Math.min(grid[i][j - 1], level) << 1 : 0;
                }
            }
        }
        return area;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public int numRookCaptures(char[][] board) {
        Map<Integer, Integer> pUpMap = new HashMap<>();
        Map<Integer, Integer> pLeftMap = new HashMap<>();
        Map<Integer, Integer> BUpMap = new HashMap<>();
        Map<Integer, Integer> BLeftMap = new HashMap<>();
        int pDownX = -1;
        int pRightY = -1;
        int BDownX = -1;
        int BrightY = -1;
        int rx = -1, ry = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {rx = i; ry = j; continue;}
                if (rx == -1) {
                    if (board[i][j] == 'p') {
                        pUpMap.put(j, i);
                        pLeftMap.put(i, j);
                    } else if (board[i][j] == 'B') {
                        BUpMap.put(j, i);
                        BLeftMap.put(i, j);
                    }
                } else {
                    if (i == rx) {
                        if (board[i][j] == 'p' && pRightY == -1) {
                            pRightY = j;
                        } else if (board[i][j] == 'B' && BrightY == -1) {
                            BrightY = j;
                        }
                    } else if (j == ry) {
                        if (board[i][j] == 'p' && pDownX == -1) {
                            pDownX = i;
                        } else if (board[i][j] == 'B' && BDownX == -1) {
                            BDownX = i;
                        }
                    }
                }
            }
        }
        //处理
        int count = 0;
        count += pRightY == -1 ? 0 : BrightY != -1 && BrightY < pRightY ? 0 : 1;
        count += pDownX == -1 ? 0 : BDownX != -1 && BDownX < pDownX ? 0 : 1;
        count += !pUpMap.containsKey(ry) ? 0 : BUpMap.containsKey(ry) && BUpMap.get(ry) > pUpMap.get(ry) ? 0 : 1;
        count += !pLeftMap.containsKey(rx) ? 0 : BLeftMap.containsKey(rx) && BLeftMap.get(rx) > pLeftMap.get(rx) ? 0 : 1;
        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            new char[] {'.','.','.','.','.','.','.','.'},
            new char[] {'.','.','.','p','.','.','.','.'},
            new char[] {'.','.','.','R','.','.','.','p'},
            new char[] {'.','.','.','.','.','.','.','.'},
            new char[] {'.','.','.','.','.','.','.','.'},
            new char[] {'.','.','.','p','.','.','.','.'},
            new char[] {'.','.','.','.','.','.','.','.'},
            new char[] {'.','.','.','.','.','.','.','.'}

        };
        ReverseNodesInK_Group r = new ReverseNodesInK_Group();
        r.numRookCaptures(board);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
