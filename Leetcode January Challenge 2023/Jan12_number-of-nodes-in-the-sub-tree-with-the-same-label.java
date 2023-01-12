/*Link: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/ 
You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.

Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.

A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

Example 1:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself). */

Author - @SarthakKotewale

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        //Jan 12 DC
        int[] count = new int[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0, -1, graph, labels, count);
        return count;
    }
    private int[] dfs(int currentNode, int parentNode, ArrayList<Integer>[] graph, String labels, int[] count){
        int[] countArray = new int[26];
        for(int childNode: graph[currentNode]){
            if(childNode != parentNode){
                int[] res = dfs(childNode, currentNode, graph, labels, count);
                for(int i = 0; i < res.length; i++){
                    countArray[i] += res[i];
                }
            }
        }
        count[currentNode] = ++countArray[labels.charAt(currentNode) - 'a'];
        return countArray;
    }
  
}