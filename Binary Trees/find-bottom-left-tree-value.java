/*Given the root of a binary tree, return the leftmost value in the last row of the tree. (MEDIUM) */

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
    
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        leftView(root);
        return res;
    }
    public ArrayList<Integer> leftView(TreeNode root){
      
      ArrayList<Integer> list = new ArrayList<>();
      if(root == null){
          return list;
      }
      
      Queue<TreeNode> qu = new LinkedList<>();
      qu.add(root);
      
      while(qu.size() > 0){
        int size = qu.size();
        
        for(int i = 0; i < size; i++){
            TreeNode temp = qu.remove();
            
            if(i == 0){
                list.add(temp.val);
            }
            
            if(temp.left != null){
                qu.add(temp.left);
            }
            if(temp.right != null){
                qu.add(temp.right);
            }
        }
        res = list.get(list.size() - 1); //last element of 'list' that contains left view
      }
      return list;
    }
}