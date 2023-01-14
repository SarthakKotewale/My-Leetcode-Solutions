/* Link: https://leetcode.com/problems/k-th-smallest-prime-fraction/ 
You are given a sorted integer array arr containing 1 and prime numbers,
where all the integers of arr are unique. You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].

Return the kth smallest fraction considered. Return your answer as an array of integers of size 2,
where answer[0] == arr[i] and answer[1] == arr[j].

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation: The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5. */

Author - @SarthakKotewale

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;
        
        while(lo < hi){
            double mid = (lo + hi) / 2;
            int actual = 0;
            int j = 0;
            
            int p = 0;
            int q = 1;
            
            for(int i = 0; i < arr.length; i++){
                while(j < arr.length && arr[i] * 1.0 / arr[j] > mid){ //arr[i] > mid * arr[j]
                    j++;
                }
                if(j == arr.length){
                    break; 
                }
                actual += (arr.length - j);
                
                if(arr[i] * 1.0 / arr[j] > p * 1.0 / q){
                    p = arr[i];
                    q = arr[j];
                }
            }
            
            if(actual < k){
                lo = mid;
            }else if(actual > k){
                hi = mid;
            }else{
                return new int[]{p, q};
            }
        }
        return null;
    }
}