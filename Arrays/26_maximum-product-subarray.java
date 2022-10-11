/*
Given an integer array nums, find a contiguous non-empty subarray within the array
that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*/

//Author - @SarthakKotewale

class Solution {
    public int maxProduct(int[] nums) {
        
        int res = Integer.MIN_VALUE;
        
        int prod = 1;
        for(int i = 0; i < nums.length; i++){
            prod = prod * nums[i];
            res = Math.max(res, prod);
            if(prod == 0){
                prod = 1;
            }
        }
        
        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            prod = prod * nums[i];
            res = Math.max(res, prod);
            if(prod == 0){
                prod = 1;
            }
        }
        
        return res;
    }
}