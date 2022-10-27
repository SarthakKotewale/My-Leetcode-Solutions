/*
The width of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums.
Since the answer may be very large, return it modulo 109 + 7.

A subsequence is a sequence that can be derived from an array by deleting some or no elements
without changing the order of the remaining elements.

For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
*/

//Author - @SarthakKotewale

class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        long ans = 0;
        long mod = 1000000007;
        int n = nums.length;
        long[] pow = new long[n];
        pow[0] = 1;
        
        for(int i = 1; i < n; i++){
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        
        for(int i = 0; i < n; i++){
            ans = (ans + nums[i] * (pow[i] - pow[n - i - 1])) % mod;
        }
        
        return (int)ans;
    }
}