/*(IMP)
Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.
 

Example 1:

Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
Output: true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

Example 2:

Input: arr = [1,2,3,4,5,6], k = 7
Output: true
Explanation: Pairs are (1,6),(2,5) and(3,4).

Example 3:

Input: arr = [1,2,3,4,5,6], k = 10
Output: false
Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10. */


//Method 1(my method)
class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            int rem = val % k;
            if(rem < 0){
                rem += k;
            }
            int of = map.getOrDefault(rem, 0);
            map.put(rem, of + 1);
        }

        for(int val : arr){
            int rem = val % k;
            
            if(rem == 0){
                int fq = map.get(rem);
                if(fq % 2 == 1){
                    return false;
                }
            }
            else if(2 * rem == k){
                int fq = map.get(rem);
                if(fq % 2 == 1){
                    return false;
                }
            }
            else{
                int fq = map.getOrDefault(rem, 0);
                int oldf = map.getOrDefault(k - rem, 0);
                if(fq != oldf){
                    return false;
                }
            }
        }
        return true;
    }
}


// Method 2
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for(int num : arr){
            num %= k;
            if(num < 0){
                num += k;
            }
            frequency[num]++;
        }
        if(frequency[0] % 2 != 0){
            return false;
        }
        
        for(int i = 1; i <= k/2; i++)
            if(frequency[i] != frequency[k-i]) {
                return false;
            }
			
        return true;
    }
}