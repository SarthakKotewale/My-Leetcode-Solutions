/* Link : https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits. */

Author - @SarthakKotewale

//Runtime: 1 ms, faster than 99.49% of Java online submissions for Find Numbers with Even Number of Digits.

class Solution {
    public int findNumbers(int[] nums) {
        int even_num = 0;
        for(int val : nums){
            int is_even = (int)Math.log10(val) + 1;
            if(is_even % 2 == 0){
                even_num++;
            }
        }
        return even_num;
    }
}