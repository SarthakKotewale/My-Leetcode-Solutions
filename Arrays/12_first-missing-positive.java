/*
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:
Input: nums = [1,2,0]
Output: 3

Example 2:
Input: nums = [3,4,-1,1]
Output: 2

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
*/ 

//Author - @SarthakKotewale

// Solution -

/*Numbers greater then n can be ignored because the missing integer must be in the range 1..n+1

If each cell in the array were to contain positive integers only, we can use the negative of the stored number as a flag to mark something (in this case the flag indicates this index was found in some cell of the array)*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }
        
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]);
            if(val <= n){
                int idx = val - 1;
                if(nums[idx] > 0){
                    nums[idx] = -1 * nums[idx];    
                }
                
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
