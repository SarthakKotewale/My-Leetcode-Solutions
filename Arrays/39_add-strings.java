/*
Given two non-negative integers, num1 and num2 represented as string,
return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library
for handling large integers(such as BigInteger).

You must also not convert the inputs to integers directly.

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
*/

Author - @SarthakKotewale

class Solution {
    public String addStrings(String num1, String num2) {
        
        String res = "";
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0 || carry != 0){
            int ival = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jval = j >= 0 ? num2.charAt(j) - '0' : 0;
            i--;
            j--;
            
            int sum = ival + jval + carry;
            res = (sum % 10) + res;
            carry = sum / 10;
        }
        return res;
    }
}