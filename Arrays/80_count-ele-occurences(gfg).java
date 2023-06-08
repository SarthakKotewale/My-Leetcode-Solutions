/*Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.

Example 1:

Input:
N = 8
arr[] = {3,1,2,2,1,2,3,3}
k = 4
Output: 2
Explanation: In the given array, 3 and
 2 are the only elements that appears 
more than n/k times.

Example 2:

Input:
N = 4
arr[] = {2,3,3,2}
k = 3
Output: 2
Explanation: In the given array, 3 and 2 
are the only elements that appears more 
than n/k times. So the count of elements 
are 2. */


class Solution {
    public int countOccurence(int[] arr, int n, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            if(map.containsKey(val)){
                int v = map.get(val);
                map.put(val, v + 1);
            }else{
                map.put(val, 1);
            }
        }
        for(int ele : map.keySet()){
            int val = map.get(ele);
            if(val > (n / k)){
                cnt++;
            }
        }
        return cnt;
    }
}
