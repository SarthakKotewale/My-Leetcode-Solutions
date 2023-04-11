/*You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
Recover the tree without changing its structure.

Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid. */

class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode curr = root;
        TreeNode n1 = null;
        TreeNode n2 = null;
        
        while(curr != null){
            if(curr.left == null){
                if(prev != null){
                    if(curr.val < prev.val){
                        if(n1 == null){
                            n1 = prev;
                        }

                        n2 = curr;
                    }    
                }
                
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    iop.right = curr; // making the thread
                    curr = curr.left;
                } else {
                    if(prev != null){
                        if(curr.val < prev.val){
                            if(n1 == null){
                                n1 = prev;
                            }
                            
                            n2 = curr;
                        }    
                    }
                    
                    prev = curr;
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}