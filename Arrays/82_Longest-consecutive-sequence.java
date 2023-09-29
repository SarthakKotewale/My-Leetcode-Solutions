//Brute - TLE Error O(N^2)
class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSeq = 0;
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            int cnt = 1;
            while(ls(nums, x + 1) == true){
                cnt++;
                x++;
            }
            longestSeq = Math.max(longestSeq, cnt);
        }
        return longestSeq;
    }
    public boolean ls(int[] nums, int x){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == x){
                return true;
            }
        }
        return false;
    }
}
// Better
