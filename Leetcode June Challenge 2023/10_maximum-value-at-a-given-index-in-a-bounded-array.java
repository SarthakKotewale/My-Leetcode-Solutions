/*You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.

Example 1:

Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].

Example 2:

Input: n = 6, index = 1,  maxSum = 10
Output: 3 */


class Solution {
    public int maxValue(int n, int index, int maxSum) {
        //DC 10.6.23
        int sum = n;
        int l = index, r = index;
        int res = 1;  //intial height

    while(sum + (r-l+1) <= maxSum) {
        sum += r-l+1;
		
		// ensuring l doesn't go below 0 && r doesn't go beyond n-1
        l = l == 0 ? 0 : l-1;
        r = r == n-1 ? r : r+1;
        res++;   

		//optimizing once l == 0 and r == n-1 as we need to add n in each step
        if(l == 0 && r == n-1) {
            int steps = 0;
            steps += (maxSum - sum)/n;
            sum += (steps * n);
            res += steps;
        }
    }
    return res;
    }
}