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
    private static int num = 0;
    private static int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return num;
    }
    public void helper(TreeNode node){
        if(node.left != null){
            helper(node.left);
            
        }
        count--;
        if(count == 0){
            num = node.val;
            return;
        }
        if(node.right != null){
            helper(node.right);
        }
    }
}
//Also a good approach --->
// int count = 0;
// int result = Integer.MIN_VALUE;

// public int kthSmallest(TreeNode root, int k) {
//     traverse(root, k);
//     return result;
// }

// public void traverse(TreeNode root, int k) {
//     if(root == null) return;
//     traverse(root.left, k);
//     count ++;
//     if(count == k) result = root.val;
//     traverse(root.right, k);       
}



