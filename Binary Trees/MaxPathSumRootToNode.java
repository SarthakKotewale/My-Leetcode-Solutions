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