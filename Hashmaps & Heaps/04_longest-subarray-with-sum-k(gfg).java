/*Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

Example 1:

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.

Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6. */



//BRUTEFORCE ~ O(N^3)
class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {
        int ans = 0;
        for(int i = 0; i < N; i++){
            
            for(int j = i; j < N; j++){
                
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += A[k];
                }
                
                if(sum == K){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}


//BRUTEFORCE2 ~ O(N^2)
class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {
        int ans = 0;
        for(int i = 0; i < N; i++){
            
            int sum = 0;
            for(int j = i; j < N; j++){
                
                sum += A[j];
                
                if(sum == K){
                    ans = Math.max(ans, j - i + 1);
                }                
            }
        }
        return ans;
    }
}


// BETTER approach
class Solution{
    public static int lenOfLongSubarr (int A[], int N, int K) {

        // By Hashing
        HashMap<Integer, Integer> map = new HashMap<>(); //prefix sum hashmap
        int sum = 0;
        int maxlen = 0;
        for(int i = 0; i < N; i++){
            sum += A[i];
            if(sum == K){
                maxlen = Math.max(maxlen, i + 1);
            }
            int rem = sum - K;
            
            if(map.containsKey(rem) == true){
                int len = i - map.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            
            if (!map.containsKey(sum)) {        // <-- ??
                map.put(sum, i);
            }
        }
        
        return maxlen;
    }
}  
/* But above code works for positive values only. If there are 0's in the array,
code will not work */





