/*
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

Example 1:

Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 */

// Author - @SarthakKotewale
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        int m = mat.length; //r
        int n = mat[0].length; //c
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int gap = i - j;
                
                if(map.containsKey(gap) == false){
                    map.put(gap, new PriorityQueue<>());
                }
                
                map.get(gap).add(mat[i][j]);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int gap = i - j;
                mat[i][j] = map.get(gap).remove();
            }
        }
        return mat;
    }
}