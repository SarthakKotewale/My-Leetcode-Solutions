/*Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.

Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
Explanation: Window 1 of size k = 4 is
1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

Example 2:

Input:
N = 3, K = 2
A[] = {4,1,1}
Output: 2 1 */


class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k){
        //Acquire & release
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        cnt = map.size();
        list.add(cnt);
        
        int j = 0;
        for(int i = k; i < A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1); //acquire
            
            if(map.get(A[j]) == 1){ //release
                map.remove(A[j]);
            }else{
                map.put(A[j], map.getOrDefault(A[j], 0) - 1);
            }
            cnt = map.size();
            list.add(cnt);
            j++;
        }
        return list;
    }
}