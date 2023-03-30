/*Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree. */

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

    class Pair implements Comparable<Pair>{
        TreeNode node;
        int w; // width
        int d; // depth

        Pair(TreeNode node, int w, int d){
            this.node = node;
            this.w = w;
            this.d = d;
        }
        public int compareTo(Pair other){ //can't insert pair in PQ without using Comparable
            if(this.d == other.d){
                return this.node.val - other.node.val;
            }else{
                return this.d - other.d;
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, 0, 1));
        
        int lmw = 0; // left most width
        int rmw = 0;

        HashMap<Integer, PriorityQueue<Pair>> hm = new HashMap<>();

        while(qu.size() > 0){
            Pair temp = qu.remove();

            if(temp.w < lmw){
                lmw = temp.w;
            }
            if(temp.w > rmw){
                rmw = temp.w;
            }
            
            if(hm.containsKey(temp.w) == false){
                hm.put(temp.w, new PriorityQueue<>());
                hm.get(temp.w).add(temp);                
            }else{
                hm.get(temp.w).add(temp);
            }

            if(temp.node.left != null){
                qu.add(new Pair(temp.node.left, temp.w - 1, temp.d + 1));
            }
            if(temp.node.right != null){
                qu.add(new Pair(temp.node.right, temp.w + 1, temp.d + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        
        for(int w = lmw; w <= rmw; w++){
            ArrayList<Integer> list = new ArrayList<>();
            PriorityQueue<Pair> pq = hm.get(w);

            while(pq.size() > 0){
                Pair t = pq.remove();
                list.add(t.node.val);
            }
            res.add(list);
        }
        return res;
    }
}

