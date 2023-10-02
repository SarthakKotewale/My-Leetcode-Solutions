/*Given an array A of positive integers.
Your task is to find the leaders in the array.
An element of array is leader if it is greater than or equal to
all the elements to its right side. The rightmost element is always a leader. 

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included. */

class Solution {
    static ArrayList<Integer> leaders(int arr[], int n){
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[arr.length - 1]);
        
        int maxlead = arr[arr.length - 1];

        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] >= maxlead){
                res.add(arr[i]);
                maxlead = Math.max(maxlead, arr[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
    
}