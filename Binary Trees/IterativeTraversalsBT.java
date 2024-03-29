import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void iterativePrePostInTraversal(Node node){
      Stack<Pair> st = new Stack<>();
      Pair rtp = new Pair(node, 1);
      st.push(rtp);
      
      String pre = "";
      String in = "";
      String post = "";
      
      while(st.size() > 0){
          Pair top = st.peek();

          if(top.state == 1){
              pre += top.node.data + " ";
              top.state++;
              
              if(top.node.left != null){
                  Pair lp = new Pair(top.node.left, 1);
                  st.push(lp);
              }
          }else if(top.state == 2){
              in += top.node.data + " ";
              top.state++;
              
              if(top.node.right != null){
                  Pair rp = new Pair(top.node.right, 1);
                  st.push(rp);
              }
          }else{
              post += top.node.data + " ";
              st.pop();
          }
      }
      System.out.println(pre);
      System.out.println(in);
      System.out.println(post);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    iterativePrePostInTraversal(root);
  }

}

//Iterative Preorder traversal method 2 ( for LEETCODE)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(st.size() > 0){
            root = st.pop();
            res.add(root.val);

            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return res;
        // if(root == null){
        //     return retVal;
        // }
        // TreeNode curr = root;
        
        // while(curr != null){
        //     if(curr.left == null){
        //         retVal.add(curr.val);
        //         curr = curr.right;
        //     }else{
        //         TreeNode iop = curr.left;
        //         while(iop.right != null && iop.right != curr){
        //             iop = iop.right;
        //         }
                
        //         if(iop.right == null){
        //             retVal.add(curr.val);
        //             iop.right = curr;
        //             curr = curr.left;
        //         }else{
        //             iop.right = null;
                    
        //             curr = curr.right;
        //         }
        //     }
        // }
        // return retVal;
    }
}


//Iterative Inorder traversal method 2 ( for LEETCODE)

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                res.add(node.val);
                node = node.right;
            }
        }

        return res;
        // if(root == null){
        //     return retVal;
        // }
        // TreeNode curr = root;
        
        // while(curr != null){
        //     if(curr.left == null){
        //         retVal.add(curr.val);
        //         curr = curr.right;
        //     }else{
        //         TreeNode iop = curr.left;
        //         while(iop.right != null && iop.right != curr){
        //             iop = iop.right;
        //         }
                
        //         if(iop.right == null){
        //             iop.right = curr; //thread
        //             curr = curr.left;
        //         }else{
        //             iop.right = null;
        //             retVal.add(curr.val);
        //             curr = curr.right;
        //         }
        //     }
        // }
        // return retVal;
    }
}