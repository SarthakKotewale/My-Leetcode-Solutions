/*There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.

You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

A good path is a simple path that satisfies the following conditions:

The starting node and the ending node have the same value.
All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
Return the number of distinct good paths.

Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.

 

Example 1:


Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
Output: 6
Explanation: There are 5 good paths consisting of a single node.
There is 1 additional good path: 1 -> 0 -> 2 -> 4.
(The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0]. */

class Solution {
    // not my solution DC 15/1/23
    int[] root;
    int[] cnt;
    int get(int x) {
        return x == root[x] ? x : (root[x] = get(root[x]));
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length, ans = n;
        cnt = new int[n];
        root = new int[n];
        
        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt[i] = 1;
        }
        // sort by vals
        List<int[]> edgesList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) edgesList.add(edges[i]);
        Collections.sort(edgesList, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                int a = Math.max(vals[x[0]], vals[x[1]]);
                int b = Math.max(vals[y[0]], vals[y[1]]);
                if(a < b) return -1;
                else if(a > b) return 1;
                else return 0;
            }
        });
        
        for (int[] e : edgesList) {
            int x = e[0], y = e[1];
            
            x = get(x);
            y = get(y);
             
            if (vals[x] == vals[y]) {
                ans += cnt[x] * cnt[y];
                root[x] = y;
                cnt[y] += cnt[x];
            } else if (vals[x] > vals[y]) {
                root[y] = x;
            } else {
                root[x] = y;
            }
        }
        return ans;
    }
}