//Method 1(gfg)
class Solution{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root, Node x){
        Node succ = null;
        if(x.right != null){
            succ = x.right;
            
            while(succ.left != null){
                succ = succ.left;
            }
            return succ;
        }
        
        while(root != null){
            if(x.data > root.data){
                root = root.right;
            }else if(x.data < root.data){
                succ = root;
                root = root.left;
            }else{
                break;
            }
        }
        return succ;
	}
}

//Method 2 (Morris)

class Solution{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root, Node x){
        Node curr = root;
        boolean found = false;
        Node succ = null;
        
        while(curr != null){
            if(curr.left == null){
                //print
                if(found == true){
                    succ = curr;
                    break;
                }
                if(curr == x){
                    found = true;
                }
                
                curr = curr.right;
            }else{
                Node iop = curr.left;
                
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    iop.right = curr; //thread
                    curr = curr.left;
                }else{
                    //print
                    if(found == true){
                        succ = curr;
                        break;
                    }
                    if(curr == x){
                        found = true;
                    }
                
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        return succ;
	}
}