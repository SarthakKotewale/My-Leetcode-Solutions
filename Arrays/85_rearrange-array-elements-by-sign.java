/*You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  */

//Bruteforce
class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int posIndex = 0;
        int negIndex = 0;
        for (int num : nums) {
            if (num > 0) {
                pos[posIndex++] = num;
            } else if (num < 0) {
                neg[negIndex++] = num;
            }
        }

        int[] arrangedArray = new int[nums.length];
        int posPointer = 0;
        int negPointer = 0;
        for (int i = 0; i < arrangedArray.length; i++) {
            if (i % 2 == 0 && posPointer < (nums.length/2)) {
                arrangedArray[i] = pos[posPointer++];
            } else if (negPointer < (nums.length/2)) {
                arrangedArray[i] = neg[negPointer++];
            }
        }
        return arrangedArray;
    }
}
/*************/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        for(int i = 0; i < nums.length / 2; i++){
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
        return nums;
    }
}
//Above both solutions are brute