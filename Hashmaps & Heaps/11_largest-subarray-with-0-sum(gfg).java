/*Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with sum 0 will be -2 2 -8 1 7 */

// (Very similar to 'Contiguous Subarray(LC)' )
class GfG {
    int maxLen(int arr[], int n){
        int maxlen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        
        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            if(map.containsKey(sum)){
                int oldIdx = map.get(sum);
                int len = i - oldIdx;
                
                if(len > maxlen){
                    maxlen = len;
                }
            }else{
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}