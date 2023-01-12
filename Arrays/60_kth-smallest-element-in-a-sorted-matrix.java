/* Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/ 

Given an n x n matrix where each of the rows and columns is sorted in ascending order,
return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
*/

Author - @SarthakKotewale

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            int actual = 0;
            int j = matrix[0].length - 1;
            
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                actual += j + 1;
            }
            
            if(actual < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}