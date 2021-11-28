package com.enkode.javacp.practices.lc.tree;

/**
 * Problem 236
 * <pre>
 *     root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *     root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * </pre>
 */
public class LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {
        TreeNode subTree1 = new TreeNode(2, new TreeNode(7, null, null), new TreeNode(4, null, null));
        TreeNode subTree2 = new TreeNode(5, new TreeNode(6, null, null), subTree1);
        TreeNode subTree3 = new TreeNode(1, new TreeNode(0, null, null), new TreeNode(8, null, null));
        TreeNode root = new TreeNode(3, subTree2, subTree3);
        int p = 5;
        int q = 4;
        System.out.println(
                lowestCommonAncestor(root, new TreeNode(p, null, null), new TreeNode(q, null, null)).val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        if(leftLca == null && rightLca == null) return null;
        else if(rightLca == null) return leftLca;
        else if(leftLca == null) return rightLca;
        else return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode leftNode, TreeNode rightNode) {
            val = x;
            left = leftNode;
            right = rightNode;
        }
    }
}
