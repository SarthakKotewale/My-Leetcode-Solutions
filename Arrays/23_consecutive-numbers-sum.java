/* Given an integer n, return the number of ways
you can write n as the sum of consecutive positive integers. 

Example 3:

Input: n = 15
Output: 4
Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
*/


//Author - @SarthakKotewale

class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int k = 1;
        int check = k * (k - 1) / 2;
        
        while(check < n){
            if((n - check) % k == 0){
                res++;
            }
            k++;
            check = k * (k - 1) / 2;
        }
        return res;
    }
}