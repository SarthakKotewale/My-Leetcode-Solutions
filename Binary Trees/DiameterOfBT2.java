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
    public int[] diameter(TreeNode root){
        if(root == null){
            return new int[] {-1, 0};
        }
        int[] la = diameter(root.left);
        int[] ra = diameter(root.right);
        
        int[] my = new int[2];  // 0 --> h , 1 --> d
        
        my[0] = Math.max(la[0], ra[0]) + 1; //myheight
        int acrossNode = la[0] + ra[0] + 2;
        my[1] = Math.max(acrossNode,(Math.max(la[1], ra[1])));
        return my;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = diameter(root);
        return ans[1];
    }
}