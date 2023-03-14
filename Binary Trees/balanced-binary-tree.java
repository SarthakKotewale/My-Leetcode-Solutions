/*Given a binary tree, determine if it is height-balanced

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false */

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
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int ls = height(root.left);
        int rs = height(root.right);
        if(Math.abs(ls - rs) > 1){
            result = false;
        }
        return (Math.max(ls, rs) + 1);
    }
}