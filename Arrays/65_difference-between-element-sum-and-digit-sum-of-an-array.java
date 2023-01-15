/*You are given a positive integer array nums.

The element sum is the sum of all the elements in nums.
The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
Return the absolute difference between the element sum and digit sum of nums.

Note that the absolute difference between two integers x and y is defined as |x - y|.

 

Example 1:

Input: nums = [1,15,6,3]
Output: 9
Explanation: 
The element sum of nums is 1 + 15 + 6 + 3 = 25.
The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
The absolute difference between the element sum and digit sum is |25 - 16| = 9. */

Author - @SarthakKotewale

//1st try
class Solution {
    public int differenceOfSum(int[] nums) {
        int arrSum = 0;
        for(int val : nums){
            arrSum += val;
        }
        int digSum = 0;
        for(int v : nums){
            if(v < 9){
                digSum += v;
            }else{
                while(v > 0){
                    int ld = v % 10;
                    v = v / 10;
                    digSum += ld;
                }
            }
        }
        return Math.abs(arrSum - digSum);
        
    }
    
}

//cleaner code
class Solution {
    public int differenceOfSum(int[] nums) {
        int esum=0, dsum = 0;
        for(int i=0; i<nums.length; i++){
            esum += nums[i];
            while(nums[i] != 0){
                dsum += nums[i]%10;
                nums[i] /= 10;
            }
        }
        return Math.abs(dsum-esum);
    }
    
}