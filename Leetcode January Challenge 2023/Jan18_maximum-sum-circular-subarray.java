/*Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2. */

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //DC 18/1/23
        // Finding total_sum of given array
        int total =nums[0];
        
        //Finding max_sum subarray     case_1 : [- - - + + + + - - -]
        int curr_max = nums[0];
        int max_so_far = nums[0];
        
        //Finding min_sum subarray      case_2:  [+ + + - - - + + +]
        int curr_min = nums[0];
        int min_so_far = nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            total += nums[i];
            
            //To find max_sum subarray
            curr_max = Math.max(nums[i], nums[i]+curr_max);
            max_so_far = Math.max(max_so_far, curr_max);
            
            //To find min_sum subarray
            curr_min = Math.min(nums[i],  curr_min+nums[i]);
            min_so_far = Math.min(curr_min, min_so_far);
        }
        
        // case when all the element is not negative
        // Simply return max of case_1 and case_2
        if(max_so_far > 0)
        {
            // case_1 , simple max_sum subarray with Kadane's algorithm
            // for case_2 , just find total_sum and remove min_sum subarray(-ve part)
            return Math.max( max_so_far, total - min_so_far );
            
        }
        
        //case  When all the elment is negative
        return max_so_far;        
    }
}