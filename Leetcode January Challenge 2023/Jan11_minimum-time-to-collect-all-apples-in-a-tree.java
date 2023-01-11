/* Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/ 
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices.
You spend 1 second to walk over one edge of the tree.
Return the minimum time in seconds you have to spend to collect all apples in the tree,
starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple,
where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

Example 1:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple.
One optimal path to collect all apples is shown by the green arrows.  

Example 2:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
*/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        java.util.Arrays.sort(edges, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for(int[] edge: edges)
            if (m.containsKey(edge[1]))
                m.put(edge[0], edge[1]);
            else
                m.put(edge[1], edge[0]);

        int result = 0;
        for(int i = 0; i < hasApple.size(); ++i) {
            if (!hasApple.get(i)) continue;
            int p = i;
            while(p != 0 && m.get(p) >= 0) {
                int temp = m.get(p);
                m.put(p, -1);
                p = temp;
                result += 2;
            }
        }
        return result;

    }
}