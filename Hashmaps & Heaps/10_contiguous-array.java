/*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.


Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1. */


class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0; 
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // (sum, index)
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum += -1;
            }else{
                sum += nums[i];
            }
            
            if(map.containsKey(sum)){
                int oldIdx = map.get(sum);
                int len = i - oldIdx;

                if(len > maxlen){
                    maxlen = len;
                }
                
            }else{
                map.put(sum, i);
            }
        }

        return maxlen;
    }
}