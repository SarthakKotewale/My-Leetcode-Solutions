/*
Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Example 2:

Input: n = 3
Output: [-1,0,1]
*/

Author - @SarthakKotewale
//Faster than 100% of submissions

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int sum = 0;
        for(int i = 0; i < n - 1; i++){
            res[i] = i + 1;
            sum += res[i];
        }
        res[n - 1] = -sum;
        return res;
    }
}