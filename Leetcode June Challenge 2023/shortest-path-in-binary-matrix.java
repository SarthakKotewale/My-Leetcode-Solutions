/*Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.


Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1 */



class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        //initialization for 8 directions, a map(map is the name, it is a Queue for BFS) and row-column boundaries
        int[][] dir = {{1,1},{1,0},{0,1},{1,-1},{-1,1},{-1,0},{0,-1},{-1,-1}};
        Queue<int[]> map =new LinkedList<>();
        int rMax = grid.length;
        int cMax = grid[0].length;
        
        //if start point is blocked, return -1, otherwise give map the start point
        if(grid[0][0]==1) return -1; 
        
        //first two parameters are coordinates, third keep track of the distance
        map.offer(new int[] {0,0,1});
        
        while(!map.isEmpty()){
            //get current coordinates and distance travelled
            int[] location = map.poll();
            int r = location[0];
            int c = location[1];
            int distance = location[2];
            
            //return if reaches the destination
            if(r==rMax-1 && c==cMax-1) return distance;
            
            //search 8 directions for unexplored points around current point
            for(int[] d : dir){
                int r2 = r + d[0];
                int c2 = c + d[1];
                if(r2<rMax && r2>=0 && c2<cMax && c2>=0 && grid[r2][c2]==0){
                    //add unexplored point to map and increment distance by 1
                    map.offer(new int[] {r2,c2,distance+1});
					//set this point to 1 as explored
                    grid[r2][c2] = 1;
                }
            }
        }   
        // whole space searched, cannot reach destination
        return -1;
    }
}