class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < left.length; i++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right[i] = nums[i + 1] * right[i + 1];
        }
        
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

//FOLLOW UP (In O(1) space complexity (output array doesn't count)) - 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < left.length; i++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        
        int right = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right = right * nums[i + 1];
            left[i] = left[i] * right;
        }
        
        
        return left;
    }
}
