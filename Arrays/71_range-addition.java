/* Link: https://www.lintcode.com/problem/903/ 
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments
each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example
Given:
length = 5,
updates = 
[   [1,  3,  2],
    [2,  4,  3],
    [0,  2, -2]    ]
return [-2, 0, 3, 5, 3]

Explanation:
Initial state:
[ 0, 0, 0, 0, 0 ]
After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]
After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]
After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
*/

Author - @SarthakKotewale

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] arr = new int[length];

        for(int[] update : updates){
            int start = update[0]; 
            int end = update[1];
            int inc = update[2];

            arr[start] += inc;
            if(end + 1 < arr.length){
                arr[end] -= inc;
            }
        }
        // now just take prefix sum of array
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1];
        }
        return arr;
    }
}