/*(Boyer–Moore Majority Vote algo.)
(read this - https://leetcode.com/problems/majority-element/discuss/543431/Majority-vote-algorithm-EXPLAINED-(with-pictures))
*/

class Solution {
    public int majorityElement(int[] nums) {
        
        int cnt = 0;
        int majEle = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                majEle = nums[i];
                cnt = 1;
            }else if(nums[i] == majEle){
                cnt++;
            }else{
                cnt--;
            }
        }
        return majEle;
    }
}
