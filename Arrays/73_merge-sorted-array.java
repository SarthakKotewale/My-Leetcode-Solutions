/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1. */

Author - @SarthakKotewale

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, bp1 = m - 1, bp2 = n - 1;  //bp --> back-pointer
        
        while(bp1 >= 0 && bp2 >= 0){
            if(nums1[bp1] > nums2[bp2])
                nums1[i] = nums1[bp1--];
            else 
                nums1[i] = nums2[bp2--];
                i--;
        }
        while(bp1 >= 0)
            nums1[i--] = nums1[bp1--];
        while(bp2 >= 0)
            nums1[i--] = nums2[bp2--];
    }
}