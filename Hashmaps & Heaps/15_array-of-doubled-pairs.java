/*Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

Example 1:

Input: arr = [3,1,3,6]
Output: false

Example 2:

Input: arr = [2,1,2,6]
Output: false

Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4]*/


class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        Arrays.sort(arr); //

        for(int val : arr){
            
            if(val != 0 && map.containsKey(val) && map.containsKey(val * 2)){
                if(map.getOrDefault(val, 0) > 1){
                    map.put(val, map.getOrDefault(val, 0) - 1);
                }else{
                    map.remove(val);
                }

                if(map.getOrDefault(2 * val, 0) > 1){
                    map.put(2 * val, map.getOrDefault(2 * val, 0) - 1);
                }else{
                    map.remove(2 * val);
                }
            }
        }
        
        if(map.size() == 0){
            return true;
        }else if(map.size() == 1 && map.containsKey(0)){
            return true;
        }else{
            return false;
        }
    }
}