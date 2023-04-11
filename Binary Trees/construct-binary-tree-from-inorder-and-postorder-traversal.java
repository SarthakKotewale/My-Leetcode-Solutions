/*Given two integer arrays inorder and postorder where inorder is the inorder traversal
of a binary tree and postorder is the postorder traversal of the same tree,
construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree. */


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode retVal = construct(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return retVal;
    }
    public TreeNode construct(int[] inorder, int[] postorder, int postlo, int posthi, int inlo, int inhi){
        if(postlo > posthi || inlo > inhi){ //basecase
            return null;
        }

        TreeNode node = new TreeNode();

        int idx = inlo;
        while(idx <= inhi){
            if(inorder[idx] == postorder[posthi]){
                break;
            }
            idx++;
        }    
        int rhs = inhi - idx;
        node.val = postorder[posthi]; //last ele in postorder[] is the starting root.
        node.left = construct(inorder, postorder, postlo, posthi - rhs - 1, inlo, idx - 1);
        node.right = construct(inorder, postorder, posthi - rhs, posthi - 1, idx + 1, inhi);

        return node;
    }
}