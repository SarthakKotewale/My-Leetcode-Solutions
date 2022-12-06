/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n]
and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
*/

//Method 1 (Bruteforce) --> TC - O(N^2)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j] && i != j){
                    res.add(nums[i]);
                }
            }
        }
        return res;
    }
}



//Method 2 (Optimised) --> TC - O(N)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            int val = nums[index];
            
            if(val < 0){
                res.add(index + 1);
            }else{
                nums[index] *= -1;
            }
        }
        return res;
    }
}