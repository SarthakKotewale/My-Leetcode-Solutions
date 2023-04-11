/*Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last,
is completely filled in a complete binary tree, and all nodes in the last level
are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity. 

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6 */

/*Google
7
Amazon
5
Tiktok
4 */


class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return ((2<<(leftHeight)) -1); //?
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    public int getLeftHeight(TreeNode root){
        int cnt = 0;
        while(root.left != null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    public int getRightHeight(TreeNode root){
        int cnt = 0;
        while(root.right != null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
}


