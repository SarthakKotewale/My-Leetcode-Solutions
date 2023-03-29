/*Given a Binary Tree, return Left view of it.
Left view of a Binary Tree is set of nodes visible when tree is visited from Left side.
The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3
 */


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree{
    
    ArrayList<Integer> leftView(Node root){
      
      ArrayList<Integer> list = new ArrayList<>();
      if(root == null){
          return list;
      }
      
      Queue<Node> qu = new LinkedList<>();
      qu.add(root);
      
      while(qu.size() > 0){
        int size = qu.size();
        
        for(int i = 0; i < size; i++){
            Node temp = qu.remove();
            
            if(i == 0){
                list.add(temp.data);
            }
            
            if(temp.left != null){
                qu.add(temp.left);
            }
            if(temp.right != null){
                qu.add(temp.right);
            }
        }
      }
      return list;
    }
}