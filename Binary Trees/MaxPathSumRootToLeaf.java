/*Given a Binary Tree, find the maximum sum path from a leaf to root.

Example 1:

Input:
        1
       / \
      2   3 
Output:
4
Explanation: 
Following the path 3 -> 1, results in a
sum of 4, which is the maximum path sum
from leaf to root for the given tree.

Example 2:

Input:
       10
      /  \
    -2    7
    / \   
   8  -4    
Output:
17
Explanation : 
Following the path 7 -> 10, results in a
sum of 17, which is the maximum path sum
from leaf to root for the given tree. */

// Approach 1
class Solution {
    public static int maxPathSum(Node root){

        if(root.left != null && root.right != null){
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);
            return Math.max(left, right) + root.data;
        }
        else if(root.left != null){
            int left = maxPathSum(root.left);
            return left  + root.data;
        }
        else if(root.right != null){
            int right = maxPathSum(root.right);
            return right + root.data;
        }
        else{
            return root.data;
        }
    }
}
