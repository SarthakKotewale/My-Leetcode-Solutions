/*Given an array containing 0s and 1s. Find the number of subarrays having equal number of 0s and 1s.

Example 1:

Input:
n = 7
A[] = {1,0,0,1,0,1,1}
Output: 8
Explanation: The index range for the 8 
sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), 
(4, 5) ,(2, 5), (0, 5), (1, 6)

Example 2:

Input:
n = 5
A[] = {1,1,1,1,0}
Output: 1
Explanation: The index range for the 
subarray is (3,4). */


class Solution {
    
    //Function to count subarrays with equal 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n){
        int cnt = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int val : arr){
            if(val == 0){
                sum += -1;
            }else{
                sum += 1;
            }
            
            if(map.containsKey(sum)){
                cnt += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            }else{
                map.put(sum, 1);
            }
        }
        return cnt;
    }
}