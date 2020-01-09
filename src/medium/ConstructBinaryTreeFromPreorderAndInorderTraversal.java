package medium;

import java.util.Arrays;

/**
 * @author 潘磊明
 * @date 2019/10/25
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return _buildTree(preorder, inorder, 0, 0, inorder.length - 1);
//    }
//
//    private TreeNode _buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
//        if (preStart >= preorder.length || inStart > inEnd) return null;
//        TreeNode node = new TreeNode(preorder[preStart]);
//        int mid = 0;
//        for (int i = inStart; i < inEnd + 1; i++) {
//            if (inorder[i] == preorder[preStart]) {
//                mid = i;
//            }
//        }
//        node.left = _buildTree(preorder, inorder, preStart + 1, inStart, mid - 1);
//        node.right = _buildTree(preorder, inorder, preStart + 1 + mid - inStart, mid + 1, inEnd);
//        return node;
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = search(inorder, preorder[0]);
        //左子树
        if (index > 0) {
            int[] leftInorder = Arrays.copyOfRange(inorder,0, index);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);
            root.left = buildTree(leftPreorder, leftInorder);
        }
        //右子树
        if (index != - 1 && index < inorder.length - 1) {
            int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            int[] rightPreorder = Arrays.copyOfRange(preorder, preorder.length - rightInorder.length, preorder.length);
            root.right = buildTree(rightPreorder, rightInorder);
        }
        return root;
    }

    int search(int[] source, int target) {
        for (int i = 0; i < source.length; i++) {
            if (target == source[i]) return i;
        }
        return -1;
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal cc = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        cc.buildTree(preorder, inorder);
    }
}
