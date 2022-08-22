/*
Given an integer array nums of size n,
return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.

Example 1:
Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

Example 2:
Input: nums = [1,1,1]
Output: 0
 */

 //Author - @SarthakKotewale

class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int min = Integer.MAX_VALUE;
        for(int ele : nums){
            if(ele < min){
                min = ele;
            }
        }
        for(int ele : nums){
            moves += ele - min;
        }
        return moves;
    }
}