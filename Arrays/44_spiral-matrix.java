/*Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5] */

//FASTER THAN 100% OF SUBMISSIONS

Author - @SarthakKotewale

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int minr = 0, minc = 0, maxr = matrix.length - 1, maxc = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        
        while(minr <= maxr && minc <= maxc){
            
            //tw
            for(int i = minr, j = minc; j <= maxc; j++){
                res.add(matrix[i][j]);
            }
            minr++;
            
            //rw
            for(int i = minr, j = maxc; i <= maxr; i++){ 
                res.add(matrix[i][j]);
            }
            maxc--;
            
            //bw
            if (minr <= maxr) {
                for(int i = maxr, j = maxc; j >= minc; j--){ 
                res.add(matrix[i][j]);
                }    
            }
            maxr--;
            
            //lw
            if (minc <= maxc) {
                for(int i = maxr, j = minc; i >= minr; i--){
                res.add(matrix[i][j]);
                                }    
            }
            
            minc++;
        }
        
        return res;
        
    }
}