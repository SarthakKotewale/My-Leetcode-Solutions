/*You are given two 0-indexed arrays nums and cost consisting each of n positive integers.

You can do the following operation any number of times:

Increase or decrease any element of the array nums by 1.
The cost of doing one operation on the ith element is cost[i].

Return the minimum total cost such that all the elements of the array nums become equal.

Example 1:

Input: nums = [1,3,5,2], cost = [2,3,1,14]
Output: 8
Explanation: We can make all the elements equal to 2 in the following way:
- Increase the 0th element one time. The cost is 2.
- Decrease the 1st element one time. The cost is 3.
- Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
The total cost is 2 + 3 + 3 = 8.
It can be shown that we cannot make the array equal with a smaller cost.
Example 2:

Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
Output: 0
Explanation: All the elements are already equal, so no operations are needed. */


class Solution {
    public long minCost(int[] nums, int[] cost) {
    long ans = 0;
    Map<Integer,Integer> map = new HashMap<>();
    int min = Integer.MAX_VALUE, max = 0;
    for(int i=0; i<nums.length; i++){
        map.put(nums[i], cost[i]+map.getOrDefault(nums[i], 0));
        min = Math.min(min,nums[i]);
        max = Math.max(max,nums[i]);
    }
    long cmin = map.get(min);
    long cmax = map.get(max);
    while(min<max){
        if(cmin<=cmax){
            ans += cmin;
            min++;
            cmin += map.getOrDefault(min,0);
        }else{
            ans += cmax;
            max--;
            cmax += map.getOrDefault(max,0);
        }
    }
    return ans;
}
}