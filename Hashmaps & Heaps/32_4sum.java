/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]] */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // HashSet<ArrayList<Integer>> set = new HashSet<>();
        // Arrays.sort(nums);

        // for(int i = 0; i < nums.length - 3; i++){
        //     for(int j = i + 1; j < nums.length - 2; i++){
        //         int left = j + 1;
        //         int right = nums.length - 1;

        //         while(left < right){
        //             int sum = nums[i] + nums[j] + nums[left] + nums[right];
        //             if(sum == target){
        //                 ArrayList<Integer> list = new ArrayList<>();
        //                 list.add(nums[i]);
        //                 list.add(nums[j]);
        //                 list.add(nums[left]);
        //                 list.add(nums[right]);
        //                 set.add(list);
        //                 left++;
        //                 right--;
        //             }else if(sum < target){
        //                 left++;
        //             }else{
        //                 right++;
        //             }
        //         }
        //     }
        // }
        // }
        // }


        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        output.addAll(s);
        return output;
    }
}