/*Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree,
print all diagonal elements in a binary tree belonging to same line.
If the diagonal element are present in two different subtress then left subtree
diagonal element should be taken first and then right subtree. 

Example 1:
Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13

Output : 8 10 14 3 6 7 13 1 4 */

Author - @SarthakKotewale

// METHOD - 1

class Tree {
     public ArrayList<Integer> diagonal(Node root){
           /* To solve this we will create a queue and an arraylist.
           now the thoery is if the root node has left and right elements then we
           will add the right element in the array and left element in the queue.
           once one diagonal hand is completed then we will add the first element
           of the queue to the arraylist and we will pop the same element
           and we will repeat this till we complete all the diagonal hands.
           example
           for 1st diagonal hand...
           arr.add(q.add(temp.right)) = 8 10 14
           q.add(temp.left) = 3 13
           for 2nd diagonal hand...
           arr.add(q.add(temp.right)) = 8 10 14 3 6 7 13 
           q.add(temp.left) = 3-X 13-X 1 4
           // 3 and 13 got popped out and 1 and 4 were added
           for 3rd diagonal hand...
           arr.add(q.add(temp.right)) = 8 10 14 3 6 7 13 1 4
           q.add(temp.left) = 3-X 13-X 1-X 4-X
           // 3 13 1 and 4 all got popped out from the queue and q became empty
           but array is now ready with the expected answer */

           Queue<Node> cue=new LinkedList<>();
           ArrayList<Integer> ans=new ArrayList<>();
           cue.add(root);
           
           while(!cue.isEmpty()){
               Node temp = cue.remove();
               
               while(temp!=null){
                   if(temp.left != null){
                       cue.add(temp.left);
                   }
                   ans.add(temp.data);
                   temp = temp.right;
               }
           }
           return ans;
      }
}

// METHOD 2 (INTUITIVE)

class Tree {
    static int md = 0;
    
    static void traversal(Node root, int diag, HashMap<Integer, ArrayList<Integer>> hm){
        if(root == null){
            return;
        }
        if(diag > md){
            md = diag;
        }
        if(hm.containsKey(diag) == false){
            hm.put(diag, new ArrayList<>());
        }
        hm.get(diag).add(root.data);
        
        traversal(root.left, diag + 1, hm);
        traversal(root.right, diag, hm);
    }

    public ArrayList<Integer> diagonal(Node root){
        
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        traversal(root, 0, hm);
        
        ArrayList<Integer> total = new ArrayList<>();
        for(int i = 0; i <= md; i++){
            ArrayList<Integer> list = hm.get(i);
            if(list == null){
                continue;
            }
            for(int item : list){
                total.add(item);
            }
        }
        
        return total;
    }
    
}
