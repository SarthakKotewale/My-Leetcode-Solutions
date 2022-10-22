/* 
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

//Author - @SarthakKotewale

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        Arrays.fill(isPrime, true);
        int cnt = 0;
        if(n < 2){
            return 0;
        }
        for(int i = 2; i * i <= isPrime.length; i++){
            if(isPrime[i] == true){
                // making multiple of i -> 'not prime'
                for(int j = i + i; j < isPrime.length; j += i){
                    isPrime[j] = false; //not prime
                }
            }
        }
        
        //count all the primes
        for(int i = 2; i < isPrime.length - 1; i++){
            if(isPrime[i] == true){
                cnt++;
            }
        }
        return cnt;
        
    }
}