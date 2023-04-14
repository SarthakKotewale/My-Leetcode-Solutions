/*(EASY) Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths. */

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

 // RECURSIVE
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        if(root.left == null && root.right == null && targetSum - root.val == 0){
            return true;
        }
        boolean l = hasPathSum(root.left, targetSum - root.val);
        boolean r = hasPathSum(root.right, targetSum - root.val);
        return (l || r);
    }
}

// ITERATIVE /*not my solution*/
public boolean hasPathSum(TreeNode root, int sum) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    Stack<Integer> sums = new Stack<Integer>();

    stack.push(root);
    sums.push(sum);

    while(!stack.isEmpty()&&(root!=null)){
        int value = sums.pop();
        TreeNode top = stack.pop();
        
        if(top.left==null&&top.right==null&&top.val==value){
            return true;
        }
        if(top.right!=null){
            stack.push(top.right);
            sums.push(value-top.val);
        }
        if(top.left!=null){
            stack.push(top.left);
            sums.push(value-top.val);
        }
    }
    return false;
}