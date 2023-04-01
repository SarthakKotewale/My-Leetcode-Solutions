/*Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Example 1:
Input:
        1 
      /   \
     2     3  
    / \   / \ 
   4   5 6   7
      / \
     8   9
   
Output: 1 2 4 8 9 6 7 3

Example 2:
Input:
            1
           /
          2
        /  \
       4    9
     /  \    \
    6    5    3
             /  \
            7     8

Output: 1 2 4 6 5 7 8 */


class Solution{
    
    void leftWall(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        if(node.left != null || node.right != null){
            res.add(node.data); // pre-order
        }
        
        if(node.left != null){
            leftWall(node.left, res);
        }else if(node.right != null){
            leftWall(node.right, res);
        }
    }
    
    void leaves(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        leaves(node.left, res);
        
        if(node.left == null && node.right == null){
            res.add(node.data);
        }
        
        leaves(node.right, res);
    }
    
    void rightWall(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        if(node.right != null){
            rightWall(node.right, res);
        }else if(node.left != null){
            rightWall(node.left, res);
        }
        if(node.left != null || node.right != null){
            res.add(node.data); //post-order
        }
    }
    
	ArrayList <Integer> boundary(Node node){
	    ArrayList<Integer> res = new ArrayList<>();
	    res.add(node.data);
	    leftWall(node.left, res);
	    leaves(node.left, res);
	    leaves(node.right, res);
	    rightWall(node.right, res);
	    
	    return res;
	}
}