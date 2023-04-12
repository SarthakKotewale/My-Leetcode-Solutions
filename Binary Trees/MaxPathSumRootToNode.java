class Solution {

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(Node root){
        max = Integer.MIN_VALUE;
        travel(root, 0);
        return max;
    }
    
    public static void travel(Node node, int sum){
        if(node == null){
            return;
        }
        
        if(sum + node.data > max){
            max = sum + node.data;
        }
        
        travel(node.left, sum + node.data);
        travel(node.right, sum + node.data);
    }   
}


// Approach 2 

class Solution {
    public static int maxPathSum(Node root){

        if(root.left != null && root.right != null){
            int left = maxPathSum(root.left);
            int leftd = Math.max(0, left); // if -ve don't add
            int right = maxPathSum(root.right);
            int rightd = Math.max(0, right);
            return Math.max(leftd, rightd) + root.data;
        }
        else if(root.left != null){
            int left = maxPathSum(root.left);
            int leftd = Math.max(0, left);
            return leftd  + root.data;
        }
        else if(root.right != null){
            int right = maxPathSum(root.right);
            int rightd = Math.max(0, right);
            return rightd + root.data;
        }
        else{
            return root.data;
        }
    }
}