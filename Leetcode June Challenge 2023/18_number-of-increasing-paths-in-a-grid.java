/* You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell. Since the answer may be very large, return it modulo 109 + 7.

Two paths are considered different if they do not have exactly the same sequence of visited cells.


Example 1:


Input: grid = [[1,1],[3,4]]
Output: 8
Explanation: The strictly increasing paths are:
- Paths with length 1: [1], [1], [3], [4].
- Paths with length 2: [1 -> 3], [1 -> 4], [3 -> 4].
- Paths with length 3: [1 -> 3 -> 4].
The total number of paths is 4 + 3 + 1 = 8.
Example 2:

Input: grid = [[1],[2]]
Output: 3
Explanation: The strictly increasing paths are:
- Paths with length 1: [1], [2].
- Paths with length 2: [1 -> 2].
The total number of paths is 2 + 1 = 3. */


class Solution {
    
    int[][] dp;
    int mod = (int) 1e9+7;
    public int countPaths(int[][] grid) {
        int res = 0;
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += f(i, j, grid); 
                res %= mod;
            }
        }
        return (res + grid.length*grid[0].length) % mod;
    }
    
    private int f(int i, int j, int[][] grid) {
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int count = 0;
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return 0;
        
        // Up
        if(i > 0 && grid[i][j] < grid[i-1][j])
            count += f(i-1, j, grid) + 1;
        
        // Down
        if(i < grid.length-1 && grid[i][j] < grid[i+1][j])
            count += f(i+1, j, grid) + 1;        
        
        // Left
         if(j > 0 && grid[i][j] < grid[i][j-1])
            count += f(i, j-1, grid) + 1;
        
        // Right
        if(j < grid[i].length-1 && grid[i][j] < grid[i][j+1])
            count += f(i, j+1, grid) + 1;
        
        count = count % mod;
        dp[i][j] = count;
        return count;
    }
}