class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int i = 0;
        int j = 0;
        
        while(i < nums.length){
            if(nums[i] % 2 == 1){
                i++;
            }else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return nums;
    }
}

//Approach 2 with STACKS

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                odd.push(nums[i]);
            }else{
                even.push(nums[i]);
            }
        }
        
        int[] ans = new int[nums.length];
        int i = 0;
        while(!even.isEmpty()){
            ans[i] = even.pop();
            i++;
        }
        while(!odd.isEmpty()){
            ans[i] = odd.pop();
            i++;
        }
        return ans;
    }
}
