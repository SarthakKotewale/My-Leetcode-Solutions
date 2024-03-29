/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5 */

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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ld = minDepth(root.left);
        int rd = minDepth(root.right);
        
        if(ld == 0 || rd == 0){
            return Math.max(ld, rd) + 1;
        }else{
            return Math.min(ld, rd) + 1;
        }
    }
}

//my
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ls = minDepth(root.left);
        int rs = minDepth(root.right);
        if(ls > 0 && rs > 0){
            return Math.min(ls, rs) + 1;
        }else{
            return Math.max(ls, rs) + 1;
        }
    }
}