/*Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000.

Example 1:
	Input:  nums = [1,0,1,1,0]
	Output:  4
	
	Explanation:
	Flip the first zero will get the the maximum number of consecutive 1s.
	After flipping, the maximum number of consecutive 1s is 4.

Example 2:
	Input: nums = [1,0,1,0,1]
	Output:  3
	
	Explanation:
	Flip each zero will get the the maximum number of consecutive 1s.
	After flipping, the maximum number of consecutive 1s is 3. */

// Intuition :

// The intuition behind this code is to maintain a continuous sequence of 1s while flipping at most one 0 in the binary array.

// The idea is to use two pointers to scan the array, one starting from the beginning and another moving ahead. The first pointer (j) keeps track of the start index of the current sequence of 1s, while the second pointer (i) scans the array and finds the end of the current sequence.

// At each iteration, we increment the count of zeros (cntz) if we find a zero in the current sequence. If the cntz becomes greater than 1, it means that we have found more than one zero in the current sequence, which is not allowed as per the given condition. In this case, we move the start index (j) to the right until the cntz becomes 1 or less. This is because moving the start index allows us to flip only one zero in the current sequence, thus maintaining the maximum number of consecutive 1s in the binary array.

// After each iteration, we calculate the length of the current sequence and update the maximum length found so far. Finally, we return the maximum length found as the result.


public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int len = 0;
        int cntz = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                cntz++;
            }
            while(j < i && cntz > 1){
                if(nums[j] == 0){
                    cntz--;
                }
                j++;
            }
            len = Math.max(len, i - j + 1);
        }
        return len;
    }
}

