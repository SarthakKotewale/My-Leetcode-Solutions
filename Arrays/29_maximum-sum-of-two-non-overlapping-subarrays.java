/*
Given an integer array nums and two integers firstLen and secondLen,
return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.

The array with length firstLen could occur before or after the array with length secondLen,
but they have to be non-overlapping.
A subarray is a contiguous part of an array.

Example 1:

Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.

Example 2:

Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
*/

//Author - @SarthakKotewale

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int fl, int sl) {
        int max1 = getMax(nums, fl, sl);
        int max2 = getMax(nums, sl, fl);
        int ans = Math.max(max1, max2);
        return ans;
    }
    
    
    public int getMax(int[] nums, int fl, int sl){
        int[] left = new int[nums.length];
        int sum = 0;
        
        for(int i = 0; i < left.length - 1; i++){
            sum += nums[i];
            if(i == fl - 1){
                left[i] = sum;
            }else if(i >= fl){
                sum -= nums[i - fl];
                left[i] = Math.max(sum, left[i - 1]);
            }
        }
        
        int[] right = new int[nums.length];
        sum = 0;
        for(int i = right.length - 1; i >= 0; i--){
            sum += nums[i];
            if(i == nums.length - sl){
                right[i] = sum;
            }else if(i < nums.length - sl){
                sum -= nums[i + sl];
                right[i] = Math.max(sum, right[i + 1]);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = fl - 1; i < nums.length - sl; i++){
            max = Math.max(max, left[i] + right[i + 1]); 
        }
        
        return max;
    }
}