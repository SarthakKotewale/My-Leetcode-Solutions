class Solution {
    public int largestRectangleArea(int[] heights) {
        //here
        int[] nser = nextSmallerRight(heights);
        int[] nsel = nextSmallerLeft(heights);
        
        int maxArea = 0;
        
        for(int i = 0; i < heights.length; i++){
            int width = nser[i] - nsel[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    public int[] nextSmallerRight(int[] arr){
        //here
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while(st.size() != 0){
            int idx = st.pop();
            ans[idx] = arr.length;
        }
        return ans;
    }
    public int[] nextSmallerLeft(int[] arr){
        //here
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while(st.size() != 0){
            int idx = st.pop();
            ans[idx] = -1;
        }
        return ans;
    }
}