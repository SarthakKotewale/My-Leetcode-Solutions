/*Given a positive integer n,
generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]
*/

class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        
        while(top <= bottom && left <= right){
            
            //travel right
            for(int i = left; i <= right; i++){
                result[top][i] = num++;
            }
            top++;
            
            //travel down
            for(int i = top; i <= bottom; i++){
                result[i][right] = num++;
            }
            right--;
            
            //travel left
            for(int i = right; i >= left; i--){
                result[bottom][i] = num++;
            }
            bottom--;
            
            //travel up
            for(int i = bottom; i >= top; i--){
                result[i][left] = num++;
            }
            left++;
            
        }
        return result;
    }
}