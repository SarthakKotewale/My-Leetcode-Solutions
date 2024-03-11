/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 Example 2:

Input: nums = [1], k = 1
Output: [1] */



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nle = nlerIdx(nums);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nle[j] < i + k) {
                j = nle[j];
            }
            res[i] = nums[j];
        }
        return res;
    }

    public int[] nlerIdx(int[] arr) { //next larger ele index on right 
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = arr.length; // or could take infinity
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}