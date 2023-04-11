/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree. 

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7] */


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length - 1, preorder, map);
        return root;
    }
    public TreeNode construct(int prelo, int prehi, int inlo, int inhi, int[] pre, HashMap<Integer, Integer> map){
        //basecase
        if(prelo > prehi || inlo > inhi){
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = pre[prelo];

        int index = map.get(pre[prelo]);
        int lhs = index - inlo;

        node.left = construct(prelo + 1, prelo + lhs, inlo, index - 1, pre, map);
        node.right = construct(prelo + lhs + 1, prehi, index + 1, inhi, pre, map);

        return node;
    }
}