/*Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.

Note: The Input/Output format and Example given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console.

Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2. */

Author - @SarthakKotewale

class Solution {
    static class Pair {
        Node node;
        int horiz;
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root){
        
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<Pair> qu = new LinkedList<>();
        
        Pair p = new Pair();
        p.node = root;
        p.horiz = 0;
        
        qu.add(p);
        
        int lv = 0, rv = 0; //lv/rv -> left/right vertical for sorting in HM
        
        while(qu.size() > 0){
            Pair temp = qu.remove();
            
            if(temp.horiz < lv){
                lv = temp.horiz;
            }
            
            if(temp.horiz > rv){
                rv = temp.horiz;
            }
            
            hm.put(temp.horiz, temp.node); //* only change
            
            if(temp.node.left != null){
                Pair lp = new Pair();
                lp.node = temp.node.left;
                lp.horiz = temp.horiz - 1;
                qu.add(lp);
            }
            if(temp.node.right != null){
                Pair rp = new Pair();
                rp.node = temp.node.right;
                rp.horiz = temp.horiz + 1;
                qu.add(rp);
            }
        }
        
        for(int i = lv ; i <= rv; i++){
            list.add(hm.get(i).data);
        }
        
        return list;
    }
}