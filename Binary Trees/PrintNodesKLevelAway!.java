/*. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
4. Input is managed for you. */

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

  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    ArrayList<Node> path = nodeToRootPath(node, data);
    
    for(int i = 0; i < path.size(); i++){
        printKLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
    }
  }
  
  public static void printKLevelsDown(Node node, int k, Node blocker){
    // code
    if(node == null || k < 0 || node == blocker){
        return;
    }
    if(k == 0){
        System.out.println(node.data);
    }
    printKLevelsDown(node.left, k - 1, blocker);
    printKLevelsDown(node.right, k - 1, blocker);
  }
  
  public static ArrayList<Node> nodeToRootPath(Node node, int data){
    // code
    if(node == null){
        return new ArrayList<>();
    }
    if(node.data == data){
        ArrayList<Node> base = new ArrayList<>();
        base.add(node);
        return base;
    }
    ArrayList<Node> ls = nodeToRootPath(node.left, data);
    if(ls.size() > 0){
        ls.add(node);
        return ls;
    }
    
    ArrayList<Node> rs= nodeToRootPath(node.right, data);
    if(rs.size() > 0){
        rs.add(node);
        return rs;
    }
    return new ArrayList<>(); //will never reach this statement
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

    int data = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}