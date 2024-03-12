/*
 * A celebrity is a person who is known to all but does not know anyone at a
 * party. If you go to a party of N people, find if there is a celebrity in the
 * party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that
 * if an element of row i and column j is set to 1 it means ith person knows jth
 * person. Here M[i][i] will always be 0.
 * Return the index of the celebrity, if there is no celebrity return -1.
 * Note: Follow 0 based indexing.
 * Follow Up: Can you optimize it to O(N)
 * 
 * Example 1:
 * 
 * Input:
 * N = 3
 * M[][] = {{0 1 0},
 * {0 0 0},
 * {0 1 0}}
 * Output: 1
 * Explanation: 0th and 2nd person both
 * know 1. Therefore, 1 is the celebrity.
 * 
 * Example 2:
 * 
 * Input:
 * N = 2
 * M[][] = {{0 1},
 * {1 0}}
 * Output: -1
 * Explanation: The two people at the party both
 * know each other. None of them is a celebrity.
 */

class Solution {

    int celebrity(int M[][], int n) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < M.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            // check if i knows j
            if (M[i][j] == 1) {
                // if i knows j implies i is not a celeb
                st.push(j);
            } else {
                // if i doesn't know j implies j is not a celeb
                st.push(i);
            }
        }

        int pCeleb = st.pop(); //potential Celeb
        for (int i = 0; i < M.length; i++) {
            if (i != pCeleb) {
                if (M[i][pCeleb] == 0 || M[pCeleb][i] == 1) {
                    return -1;
                }
            }
        }
        return pCeleb;
    }
}