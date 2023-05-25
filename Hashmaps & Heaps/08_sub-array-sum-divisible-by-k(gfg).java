/* (gfg) You are given an array A of N positive and/or negative integers and a value K.
The task is to find the count of all sub-arrays whose sum is divisible by K.

Example 1:

Input: N = 6, K = 5
       arr[] = {4, 5, 0, -2, -3, 1}
Output: 7
Explanation: There are 7 sub-arrays whose 
is divisible by K {4, 5, 0, -2, -3, 1}, {5}, 
{5, 0}, {5, 0, -2, -3}, {0}, {0, -2, -3} 
and {-2, -3}

Example 2:

Input: N = 6, K = 2
       arr[] = {2, 2, 2, 2, 2, 2}
Output: 21
Explanation: All subarray sums are 
divisible by 7 */

class Solution {
    long subCount(long arr[] ,int n,int k){
        long sum = 0;
        long cnt = 0;
        long rem = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(sum, 1L);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;
            if(rem < 0){
                rem += k;
            }

            if(map.containsKey(rem)){
                cnt += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }else{
                map.put(rem, 1L);
            }
            
        }
        return cnt;
    }
}

class Solution
{
    long subCount(long arr[] ,int n,int k){
        long cnt = 0;
        long sum = 0;
        long rem = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(sum, 1L);
        
        for(long val : arr){
            sum += val;
            rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                long v = map.get(rem);
                cnt += v;
                
                map.put(rem, v + 1L);
            }else{
                map.put(rem, 1L);
            }
        }
        
        return cnt;
    }
}