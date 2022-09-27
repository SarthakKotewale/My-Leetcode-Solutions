/*Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.

Test cases are generated such that partitioning exists.

Example 1:

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

Example 2:

Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
*/

//Author - @SarthakKotewale

class Solution {
    public int partitionDisjoint(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        for(int i = 0; i < left.length - 1; i++){
            if(i == 0){
                left[i] = nums[i];
            }else{
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(i == nums.length - 1){
                right[i] = nums[i];
            }else{
                right[i] = Math.min(nums[i], right[i + 1]);
            }
        }
        
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(left[i] <= right[i + 1]){
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}