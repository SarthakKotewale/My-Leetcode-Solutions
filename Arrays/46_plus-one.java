/*(EASY)
You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Input: digits = [9]
Output: [1,0]

Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
*/

Author - @SarthakKotewale

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                break;
            }else{
                digits[i] = 0;
            }
        }
        //for cases like 9, 99,..
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1]; 
            res[0] = 1;
            return res;
        }
        return digits;
    }
}