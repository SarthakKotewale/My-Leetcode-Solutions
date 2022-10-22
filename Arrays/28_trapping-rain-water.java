/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
*/

//Author - @SarthakKotewale

//BruteForce
class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int totalwater = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        
        max = 0;
        for(int i = n - 1; i >= 0; i--){
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        
        for(int i = n-1; i >= 0; i--){
            int cwater = Math.min(leftMax[i], rightMax[i]) - height[i];
            totalwater += cwater;
        }
        return totalwater;
    }
}

// Optimised - Faster than 99.76%
class Solution {
    public int trap(int[] height) {
        
        int n  = height.length;
        int left = 0;
        int right = n - 1;
        int maxleft = 0;
        int maxright = 0;
        int res = 0;
        
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= maxleft){
                    maxleft = height[left];
                }else{
                    res += maxleft - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= maxright){
                    maxright = height[right];
                }else{
                    res += maxright - height[right];
                }
                right--;
            }
        }
        return res;
    }
}