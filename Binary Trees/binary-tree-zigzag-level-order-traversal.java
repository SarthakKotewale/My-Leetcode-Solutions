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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>(); 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int l = 0;

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node != null){
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(!level.isEmpty()){ //imp
                if(l % 2 == 1){
                    Collections.reverse(level);
                }
                list.add(level);
            }
            l++;
        }
        return list;
    }
}