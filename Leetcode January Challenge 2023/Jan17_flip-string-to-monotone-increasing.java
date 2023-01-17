/* Link: https://leetcode.com/problems/flip-string-to-monotone-increasing/submissions/ 
A binary string is monotone increasing if it consists of some number of 0's (possibly none),
followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.

Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
*/

/*Method:
Approach and Explanation

This is a solution in Java for the problem of finding the minimum number of flips required to make a binary string monotonically increasing. A monotonically increasing string is one in which the characters are in increasing order, so for example '001' is monotonically increasing but '110' is not.

The approach used in this solution is to iterate through the string, keeping track of two variables: ans and noOfFlip. ans is initially set to 0 and will be used to store the final answer, while noOfFlip is used to keep track of the number of '1' characters that have been encountered so far.

For each character in the string, the following logic is applied:

If the current character is '0', then the minimum of noOfFlip and ans+1 is taken and assigned to ans. This is because flipping a '0' to a '1' does not affect the monotonicity of the string, so the number of flips required to make the string monotonically increasing will be the same as the number of '1' characters that have been encountered so far.

If the current character is '1', then the value of noOfFlip is incremented by 1. This is because a '1' character has been encountered, and this will have to be flipped in order to make the string monotonically increasing.

After the iteration, the final value of ans is returned as the solution.

In a summary, the solution iterates through the string and keeps track of the number of '1' characters encountered so far and the number of flips required to make the string monotonically increasing. At each step, it compares the number of flips required to the number of '1' characters encountered so far and chooses the minimum of the two as the number of flips required for the current substring.
*/

Author - @SarthakKotewale

class Solution {
    public int minFlipsMonoIncr(String s) {
        //DC 17/1/23
        int res = 0;
        int flips = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                flips++;
            }else{
                res = Math.min(flips, res + 1);
            }
        }
        return res;
    }
}
