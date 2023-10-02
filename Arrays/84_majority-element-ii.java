/*Given an integer array of size n, find all elements that
appear more than ⌊ n/3 ⌋ times.


Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1] */

//Better code but NOT OPTIMAL
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Not optimal
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int mini = (nums.length / 3) + 1;

        for (int i = 0; i < nums.length; i++) {
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val + 1);

            if (map.get(nums[i]) == mini) {
                res.add(nums[i]);
            }
            if (res.size() == 2)
                break;
        }
        return res;
    }
}


//OPTIMAL - Boyer Moore Majority voting algo.
