/* Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.

Example 1:

Input: n = 3
a = {1, 6, 2}
Output: -1 1 1
Explaination: There is no number at the left of 1. Smaller number than 6 and 2 is 1.

Example 2:

Input: n = 6
a = {1, 5, 0, 3, 4, 5}
Output: -1 1 -1 0 3 4
Explaination: Upto 3 it is easy to see 
the smaller numbers. But for 4 the smaller 
numbers are 1, 0 and 3. But among them 3 
is closest. Similary for 5 it is 4. */

// (gfg)
class Solution {
    static List<Integer> leftSmaller(int n, int arr[]) {

        Stack<Integer> st = new Stack<>();
        List<Integer> nsol = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= st.peek()) {
                st.pop();
            }
            if (st.size() > 0) {
                nsol.add(st.peek());
            } else {
                nsol.add(-1);
            }
            st.push(arr[i]);
        }
        return nsol;
    }
}

//(pep)
// public int[] solve(int[] arr) {

//     Stack<Integer> st = new Stack<>();
//     int[] nsol = new int[arr.length];

//     for (int i = 0; i < arr.length; i++) {
//         while (st.size() > 0 && arr[i] <= st.peek()) {
//             st.pop();
//         }
//         if (st.size() > 0) {
//             nsol[i] = st.peek();
//         } else {
//             nsol[i] = -1;
//         }
//         st.push(arr[i]);
//     }
//     return nsol;
// }