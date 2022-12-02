/*
You are given an n x n 2D matrix representing an image,
rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/

Author - @SarthakKotewale

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    
    public int[][] transpose(int[][] mat){
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0; j < i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }
    
    public int[][] reverse(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            int l = 0, r = mat.length - 1;
            while(l < r){
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                
                l++;
                r--;
            }
        }
        return mat;
    }   
}

// 100% faster*