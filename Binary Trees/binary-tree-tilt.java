/*Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
The rule is similar if the node does not have a right child. */

Author - @SarthakKotewale

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        traversal(root);
        return tilt;
    }
    private int traversal(TreeNode root){
        if(root == null){
            return 0;
        }
        int ls = traversal(root.left);
        int rs = traversal(root.right);
        int ltilt = Math.abs(ls - rs);
        tilt += ltilt;
        int ts = ls + rs + root.val;

        return ts;
    }
}