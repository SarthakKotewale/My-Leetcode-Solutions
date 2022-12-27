/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that
the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18. */

Author - @SarthakKotewale

class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0; //highest val in the array
        int hi = 0;
        
        for(int num : nums){
            lo = Math.max(lo, num);
            hi += num;
        }
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int limit = mid;
            
            int countParts = 1;
            int currPartSum = 0;
            for(int num : nums){
                if(currPartSum + num <= limit){
                    currPartSum += num;
                }else{
                    currPartSum = num;
                    countParts++;
                }
            }
            if(countParts > m){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}