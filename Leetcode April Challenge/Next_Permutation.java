import java.util.*;

class Solution {
    
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int firstDecreasing = findFirstDecreasing(nums);
        
        if(firstDecreasing != -1){
            int justGreater = findJustGreater(nums, firstDecreasing);
            swap(nums, firstDecreasing, justGreater);
        }
        Arrays.sort(nums, firstDecreasing + 1, nums.length);
        
    }

    private int findFirstDecreasing(int[] nums){
        for(int firstDecreasing = nums.length - 1; firstDecreasing >= 0; firstDecreasing--){
            if(firstDecreasing < nums.length - 1 && nums[firstDecreasing] < nums[firstDecreasing + 1]){
                return firstDecreasing;
            }
        }
        return -1;
    }

    private int findJustGreater(int[] nums, int firstDecreasing){
        for(int justGreater = firstDecreasing + 1; justGreater < nums.length; justGreater++){
            if(nums[justGreater] <= nums[firstDecreasing]){
                return justGreater - 1;
            }
        }
        return nums.length - 1;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
