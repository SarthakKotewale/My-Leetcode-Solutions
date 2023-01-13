/* Link: https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/ (HARD)

Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an
integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

Example 1:

Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.

Example 2:

Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6. */

Author - @SarthakKotewale

class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        // Very similar to https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
        int lo = 1;
        int hi = m * n;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int actual = 0;
            int j = n;
            
            for(int i = 1; i <= m; i++){
                while(j >= 0 && i * j > mid){
                    j--;
                }
                actual += j;
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