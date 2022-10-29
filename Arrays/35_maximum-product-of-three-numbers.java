/*Given an integer array nums, find three numbers whose product is maximum and
return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6

Example 2:

Input: nums = [1,2,3,4]
Output: 24

Example 3:

Input: nums = [-1,-2,-3]
Output: -6
*/

//Author - @SarthakKotewale

class Solution {
    public int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);
        int a = nums.length - 1;
        int b = nums.length - 2;
        int c = nums.length - 3;
        int i = 0;
        int j = 1;

        int prod = Math.max(nums[a]*nums[b]*nums[c], nums[i]*nums[j]*nums[a]);
        return prod;
    }
}