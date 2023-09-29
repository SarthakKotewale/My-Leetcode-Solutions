//Brute - TLE Error O(N^2)
class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int cnt = 1;
            while (ls(nums, x + 1) == true) {
                cnt++;
                x++;
            }
            longestSeq = Math.max(longestSeq, cnt);
        }
        return longestSeq;
    }

    public boolean ls(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return true;
            }
        }
        return false;
    }
}

// Better
class Solution {
    public int longestConsecutive(int[] nums) {
        //Better
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longestSeq = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 == lastSmaller){
                cnt++;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller){
                cnt = 1;
                lastSmaller = nums[i];
            }
            longestSeq = Math.max(longestSeq, cnt);
        }
        return longestSeq;
    }
}