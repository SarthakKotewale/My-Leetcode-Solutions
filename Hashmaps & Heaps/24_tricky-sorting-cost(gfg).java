/*Given an array arr[] of N elements containing first N positive integers. You have to sort the integers in ascending order by the following operation. Operation is to pick an integer and place it at end or at start. Every such operation increases cost by one. The task is to sort the array in the minimum cost

Example 1:

Input: N = 3
arr = {2, 1, 3}
Output: 1
Explaination: Place 1 at start.

Example 2:

Input: N = 4
arr = {4, 3, 1, 2}
Output: 2
Explaination: First place 3 at end then 4 at end. */


class Solution{
    static int sortingCost(int N, int arr[]){
        
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : arr){
            if(map.containsKey(val - 1)){
                map.put(val, map.get(val - 1) + 1);
            }else{
                map.put(val, 1);
            }
            
            if(map.get(val) > max){
                max = map.get(val);
            }
        }
        return N - max;
    }
}