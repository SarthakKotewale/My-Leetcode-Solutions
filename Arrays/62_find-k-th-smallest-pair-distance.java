/* Link: https://leetcode.com/problems/find-k-th-smallest-pair-distance/ 
The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs
nums[i] and nums[j] where 0 <= i < j < nums.length.

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0. */

Author - @SarthakKotewale

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int lo = 0;
        for(int i = 0; i < nums.length - 1; i++){
            lo = Math.min(lo, nums[i + 1] - nums[i]); //lowest gap
        }
        
        int hi = nums[nums.length - 1] - nums[0]; //highest gap
        
        while(lo < hi){
            int mid = (lo + hi) / 2; 
            int actual = 0;
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                while(j < nums.length && nums[j] - nums[i] <= mid){
                    j++;
                }
                actual += j - i - 1;
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