//In-order
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //morris traversal
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode iop = curr.left; //iop -> inorder predecessor
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }

                if(iop.right == null){
                    iop.right = curr; // thread
                    curr = curr.left; //imp
                }else{
                    iop.right = null; // break the thread
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;


        /**** */
        // List<Integer> res = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode node = root;
        // while(true){
        //     if(node != null){
        //         st.push(node);
        //         node = node.left;
        //     }else{
        //         if(st.isEmpty()){
        //             break;
        //         }
        //         node = st.pop();
        //         res.add(node.val);
        //         node = node.right;
        //     }
        // }

        // return res;
    }
}

// Pre-Order

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //morris
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    list.add(curr.val);
                    iop.right = curr;
                    curr = curr.left;
                }else{
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}